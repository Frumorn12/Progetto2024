package it.unical.informatica.progettobackend.persistenza;


import it.unical.informatica.progettobackend.persistenza.dao.PiattoDao;
import it.unical.informatica.progettobackend.persistenza.dao.PreferitiDao;
import it.unical.informatica.progettobackend.persistenza.dao.postgres.*;

import java.sql.*;

public class DBManager {
    private static DBManager instance = null;

    private DBManager() {
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    Connection con = null;

    public Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/web_app", "postgres", "postgres");
                //qui creo connessione, localhost/porta dove è il database/nome_db, nome ut, password

                System.out.println("Connessione al database avvenuta con successo");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }


    public static void main(String[] args) {
        Connection con = DBManager.getInstance().getConnection(); //istanzio la connessione al db tramite il metodo getConnection
        try {
            Statement st = con.createStatement(); //creo uno statement per eseguire query
            ResultSet rs = st.executeQuery("select utenti from utenti"); //eseguo la query e salvo il risultato in un resultset
            rs.next(); //mi sposto sulla prima riga del resultset
            System.out.println(rs.getString("utenti")); //stampo il valore della colonna utente della prima riga del resultset

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public PiattoDao getPiattiDao() {
        return new PiattoDaoPostgres(getConnection());



    }


    public UtenteDaoPostgres getUtenteDao() {
        return new UtenteDaoPostgres(getConnection());
    }

    public RecensioneDaoPostgres getRecensioneDao() {
        return new RecensioneDaoPostgres(getConnection());
    }

    public PreferitiDaoPostgres getPreferitiDao() {
        return new PreferitiDaoPostgres(getConnection());
    }

    public CarrelloDaoPostregres getCarrelloDao() {
        return new CarrelloDaoPostregres(getConnection());
    }

    public HamburgerDaoPostgres getHamburgerDao() {
        return new HamburgerDaoPostgres(getConnection());
    }
}