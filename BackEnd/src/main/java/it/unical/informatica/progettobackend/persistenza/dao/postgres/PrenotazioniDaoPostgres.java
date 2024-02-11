package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.dao.PrenotazioniDao;
import it.unical.informatica.progettobackend.persistenza.model.Prenotazione;
import it.unical.informatica.progettobackend.persistenza.model.Segnalazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioniDaoPostgres implements PrenotazioniDao {

    Connection connection;

    public PrenotazioniDaoPostgres(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> getDate() {
        try{
            String query = "select data from prenotazione_tavolo order by data";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            List<String> date = new ArrayList<>();
            while(rs.next()){
                date.add(rs.getString("data"));
            }
            return date;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void aggiungiPrenotazione(String nome, String cognome, String numero, String email, String data, String commenti, String username) {
        try {
            String query = "insert into prenotazione_tavolo (nome, cognome, telefono, email, data, commenti, utente, accettato, rifiutato) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nome);
            st.setString(2, cognome);
            st.setString(3, numero);
            st.setString(4, email);
            st.setString(5, data);
            st.setString(6, commenti);
            st.setString(7, username);
            st.setBoolean(8, false);
            st.setBoolean(9, false);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Prenotazione> getPrenotazioni() {
        List<Prenotazione> prenotazioni = new ArrayList<>();
        try{
            String query = "select * from prenotazione_tavolo order by data";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Prenotazione prenotazione = new Prenotazione(rs.getString("nome"),rs.getString("cognome"),rs.getString("telefono"),rs.getString("email"),rs.getString("data"),rs.getString("commenti"),rs.getString("utente"),rs.getBoolean("accettato"),rs.getBoolean("rifiutato"), rs.getInt("id"));
                prenotazioni.add(prenotazione);
            }
            return prenotazioni;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prenotazioni;
    }

    @Override
    public void accettaPrenotazione(int id) {
        try {
            String query = "update prenotazione_tavolo set accettato = true where id = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rifiutaPrenotazione(int id) {
        try {
            String query = "update prenotazione_tavolo set rifiutato = true where id = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Prenotazione> getPrenotazioniUtente(String username) {
        List<Prenotazione> prenotazioni = new ArrayList<>();
        try{

            String query = "select * from prenotazione_tavolo where utente = ? order by data";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Prenotazione prenotazione = new Prenotazione(rs.getString("nome"),rs.getString("cognome"),rs.getString("telefono"),rs.getString("email"),rs.getString("data"),rs.getString("commenti"),rs.getString("utente"),rs.getBoolean("accettato"),rs.getBoolean("rifiutato"), rs.getInt("id"));
                prenotazioni.add(prenotazione);
            }
            return prenotazioni;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prenotazioni;
    }

    @Override
    public List<Segnalazione> getSegnalazioni() {
        List<Segnalazione> segnalazioni = new ArrayList<>();
        try{
            String query = "select * from segnalazioni";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Segnalazione segnalazione = new Segnalazione(rs.getString("richiesta"),rs.getString("nome"),rs.getString("cognome"),rs.getString("email"),rs.getString("commenti"));
                segnalazioni.add(segnalazione);
            }
            return segnalazioni;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return segnalazioni;
    }
}
