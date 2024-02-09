package it.unical.informatica.progettobackend.persistenza.dao.postgres;
import it.unical.informatica.progettobackend.persistenza.DBManager;
import it.unical.informatica.progettobackend.persistenza.dao.CarrelloDao;
import it.unical.informatica.progettobackend.persistenza.model.Carrello;
import it.unical.informatica.progettobackend.persistenza.model.UtenteVia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarrelloDaoPostregres implements CarrelloDao{

    Connection connection;

    public CarrelloDaoPostregres(Connection connection){
        this.connection = connection;
    }

    @Override
    public void putInCarrello(String username, String piatto, double prezzo) {
        try {

            if (checkCarrello(username, piatto)) {
                String query = "UPDATE carrello SET quantita = quantita + 1 WHERE utente = ? and nome = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, piatto);
                statement.executeUpdate();

            }
            else {
                String query = "INSERT INTO carrello (utente, nome, prezzo, quantita) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, piatto);
                statement.setDouble(3, prezzo);
                statement.setInt(4, 1);
                statement.executeUpdate();


            }

        } catch (SQLException e) {
        }

    }

    @Override
    public void deleteFromCarrello(String piatto, String username) {
        try {
            if (getQuantita(username,piatto)>1){
                String query = "UPDATE carrello SET quantita = quantita - 1 WHERE utente = ? and nome = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, piatto);
                statement.executeUpdate();
            }
            else {
                String query = "DELETE FROM carrello WHERE utente = ? and nome = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, piatto);
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getQuantita (String username, String piatto) {
        try {
            String query = "select quantita from carrello where utente = ? and nome = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int quantita = rs.getInt("quantita");
                System.out.println("Quantita: " + quantita);
                return quantita;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<Carrello> getCarrello(String username) {
        List<Carrello> carrello = new ArrayList<>();
        try {
            String query = "select * from carrello where utente = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Carrello c = new Carrello(username, rs.getString("nome"), rs.getDouble("prezzo"), rs.getInt("quantita"));
                carrello.add(c);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carrello;


    }

    @Override
    public void prenota(String username, String data, boolean consegna) {
        prenota_vero(username, data, consegna, "select * from carrello where utente = ?", "delete from carrello where utente = ?");




    }

    @Override
    public void prenota_hamburger(String username, String data, boolean consegna) {
        prenota_vero(username, data, consegna, "select * from hamburger where utente = ?", "delete from hamburger where utente = ?");

    }

    public void prenota_vero(String username, String data, boolean consegna, String query, String query4 ){
        try{
            System.out.println("Username dentro prenota: " + username);
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            UtenteVia utente = DBManager.getInstance().getUtenteDao().getUtenteCompleto(username);
            int id = 0;
            try{
                String query2 = "SELECT COALESCE(MAX(id), 0) + 1 AS new_id FROM prenotazione_asporto";
                PreparedStatement st2 = connection.prepareStatement(query2);
                ResultSet rs2 = st2.executeQuery();
                if (rs2.next()) {
                    id = rs2.getInt("new_id");
                }
            } catch (SQLException e) {

            }
            System.out.println("ID: " + id);


            while (rs.next()) {
                try {
                    String query3 = "INSERT INTO prenotazione_asporto (id,utente,nome_,prezzo,quantita,nome,cognome,data,via,civico,consegna) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(query3);
                    statement.setInt(1, id);
                    statement.setString(2, username);
                    statement.setString(3, rs.getString("nome"));
                    statement.setDouble(4, rs.getDouble("prezzo"));
                    statement.setInt(5, rs.getInt("quantita"));
                    statement.setString(6, utente.getNome());
                    statement.setString(7, utente.getCognome());
                    statement.setString(8, data);
                    statement.setString(9, utente.getVia());
                    statement.setInt(10, utente.getCivico());
                    statement.setBoolean(11, consegna);

                    statement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);



                }



            }
            try{

                PreparedStatement st4 = connection.prepareStatement(query4);
                st4.setString(1, username);
                st4.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkCarrello(String username, String piatto) {
        try {
            String query = "select * from carrello where utente = ? and nome = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
