package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.dao.PreferitiDao;
import it.unical.informatica.progettobackend.persistenza.model.Piatto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreferitiDaoPostgres implements PreferitiDao {
    Connection connection;
    public PreferitiDaoPostgres(Connection connection) {
        this.connection = connection;

    }


    @Override
    public boolean checkPreferiti(String piatto, String username) {
        try {
            String query = "select * from preferiti where utente = ? and piatto = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void changePreferiti(String piatto, String username) {
        System.out.println("ciao");
        if (checkPreferiti(piatto, username)) {
            try {

                System.out.println("AGGIORNO PREFERITO " + piatto + " " + username );

                String query;
                PreparedStatement st;

                boolean stato = getPreferiti(piatto, username);
                System.out.println("Stato prima dellà if: " + stato);

                if (stato){
                    System.out.println("AGGIORNO PREFERITO " + piatto + " " + username + " A FALSE");
                    query = "update preferiti set stato = false where utente = ? and piatto = ?";
                    st = connection.prepareStatement(query);
                    st.setString(1, username);
                    st.setString(2, piatto);
                    st.executeUpdate();

                } else {
                    System.out.println("AGGIORNO PREFERITO " + piatto + " " + username + " A TRUE");
                    query = "update preferiti set stato = true where utente = ? and piatto = ?";
                    st = connection.prepareStatement(query);
                    st.setString(1, username);
                    st.setString(2, piatto);
                    st.executeUpdate();
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                System.out.println("INSERISCO NUOVO PREFERITO " + piatto + " " + username );
                String query = "insert into preferiti values (?, ?, ?)";
                PreparedStatement st = connection.prepareStatement(query);
                st.setString(1, username);
                st.setString(2, piatto);
                st.setBoolean(3, true);
                st.executeUpdate();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public boolean getPreferiti(String piatto, String username) {
        try {
            String query = "select stato from preferiti where utente = ? and piatto = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();

            System.out.println("Stampo get preferiti stato di: " + piatto + " " + username);

            if (rs.next()) {

                boolean c = rs.getBoolean("stato");
                System.out.println("Stato: " + c);
                return c;

            }

            return false;


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    @Override

    public List<Piatto> findAllPreferiti(String username) {
        try {
            String query = "select * from preferiti where utente = ? and stato = true";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            List<Piatto> piatti = new ArrayList<>( );
            while (rs.next()) {
                try{
                    String query2 = "select * from piatti where nome = ?";
                    PreparedStatement st2 = connection.prepareStatement(query2);
                    st2.setString(1, rs.getString("piatto"));
                    ResultSet rs2 = st2.executeQuery();
                    if (rs2.next()) {
                        Piatto piatto = new PiattoProxy(connection);
                        piatto.setNome(rs.getString("nome"));
                        piatto.setDescrizione(rs.getString("descrizione"));
                        piatto.setIngredienti(rs.getString("ingredienti"));
                        piatto.setPreparazione(rs.getString("preparazione"));
                        piatto.setTipo(rs.getInt("tipo"));
                        piatto.setImmagine(rs.getString("immagine"));
                        piatto.setPrezzo(rs.getDouble("prezzo"));

                        piatti.add(piatto);
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            return piatti;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
