package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.dao.RecensioneDao;
import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoPostgres implements RecensioneDao {

    Connection connection;

    public RecensioneDaoPostgres(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean addRecensione(String username, String piatto, String recensione) {
        try {
            String query = "insert into recensioni values(?,?,?,?)";
            java.sql.PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            st.setString(3, recensione);
            st.setBoolean(4, true);
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean getRecensito(String username, String piatto) {
        try {
            String query = "select * from recensioni where utente = ? and piatto = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            java.sql.ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getRecensione(String username, String piatto) {
        try {
            String query = "select * from recensioni where utente = ? and piatto = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Recensione: " + rs.getString("recensione"));
                return rs.getString("recensione");
            }
            System.out.println("Non esiste recensione");
            return null;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<RecensioneCompleta> getRecensioni() {
        List<RecensioneCompleta> recensioni = new ArrayList<>();
        try {
            String query = "select * from recensioni";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                RecensioneCompleta recensione = new RecensioneCompleta(rs.getString("recensione"), rs.getString("utente"), rs.getString("piatto"));
                recensioni.add(recensione);
            }
            return recensioni;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
