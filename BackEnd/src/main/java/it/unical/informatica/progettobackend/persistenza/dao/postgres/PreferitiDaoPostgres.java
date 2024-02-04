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
            String query = "SELECT * FROM preferiti WHERE utente = ? AND stato = true";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            List<Piatto> piatti = new ArrayList<>();

            while (rs.next()) {
                try {
                    String piattoName = rs.getString("piatto");

                    String query2 = "SELECT * FROM piatti WHERE nome = ?";
                    PreparedStatement st2 = connection.prepareStatement(query2);
                    st2.setString(1, piattoName);
                    ResultSet rs2 = st2.executeQuery();

                    if (rs2.next()) {
                        Piatto p = new PiattoProxy(connection);
                        p.setNome(rs2.getString("nome"));
                        p.setDescrizione(rs2.getString("descrizione"));
                        p.setPreparazione(rs2.getString("preparazione"));
                        p.setIngredienti(rs2.getString("ingredienti"));
                        p.setTipo(rs2.getInt("tipo"));
                        p.setImmagine(rs2.getString("immagine"));
                        p.setPrezzo(rs2.getDouble("prezzo"));
                        piatti.add(p);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
