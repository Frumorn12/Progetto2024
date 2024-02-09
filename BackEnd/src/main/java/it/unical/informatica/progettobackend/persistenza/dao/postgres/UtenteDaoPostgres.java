package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.dao.UtenteDao;
import it.unical.informatica.progettobackend.persistenza.model.Utente;
import it.unical.informatica.progettobackend.persistenza.model.UtenteCompleto;
import it.unical.informatica.progettobackend.persistenza.model.UtenteVia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDaoPostgres implements UtenteDao {
    Connection connection;

    public UtenteDaoPostgres(Connection connection){
        this.connection = connection;
    }


    @Override
    public List<Utente> findAll() {
        return null;
    }

    @Override
    public Utente findByPrimaryKey(String username) {
        Utente utente = null;
        String query = "select * from utenti where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                utente = new Utente();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setTipo(rs.getInt("tipo"));




            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utente;

    }

    @Override
    public void saveOrUpdate(Utente utente) {

    }

    @Override
    public void delete(Utente utente) {

    }

    @Override
    public boolean checkUtente(String username1) {


        System.out.println("sono qui");

        try{
            Statement st = connection.createStatement();

            String query = "select * from utenti where username = ?";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, username1);

            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean addUtente(String username, String password, int tipo, String nome, String cognome, String data, String via, int civico, String email) {
        try {

            String query = "insert into utenti values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setInt(3, tipo);
            pr.setString(4, nome);
            pr.setString(5, cognome);
            pr.setString(6, data);
            pr.setString(7, via);
            pr.setInt(8, civico);
            pr.setString(9, email);
            pr.executeUpdate();
            return true;



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public int getTipo(String username) {
        int tipo = 0;
        try{
            Statement st = connection.createStatement();

            String query = "select * from utenti where username = ?";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, username);

            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                tipo = rs.getInt("tipo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }

    @Override
    public boolean changeTipo(String username, int tipo) {
        try{
            Statement st = connection.createStatement();

            String query = "update utenti set tipo = ? where username = ?";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setInt(1, tipo);
            pr.setString(2, username);

            ResultSet rs = pr.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void segnalaci(String richiesta, String nome, String cognome, String email, String commenti) {
        try{
            Statement st = connection.createStatement();

            String query = "insert into segnalazioni values(?,?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, richiesta);
            pr.setString(2, nome);
            pr.setString(3, cognome);
            pr.setString(4, email);
            pr.setString(5, commenti);

            ResultSet rs = pr.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
    }}


    public List<UtenteCompleto> getAllUtente() {
        List<UtenteCompleto> utenti = new ArrayList<>();
        try{
            Statement st = connection.createStatement();
            String query = "select * from utenti";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                UtenteCompleto utente = new UtenteCompleto();
                utente.setUsername(rs.getString("username"));
                utente.setEmail(rs.getString("email"));
                utente.setTipo(rs.getString("tipo"));
                utenti.add(utente);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utenti;
    }

    public void getAllRec() {
        try{
            Statement st = connection.createStatement();
            String query = "r.*  from " +
                    "utente u, recensioni r " +
                    "where u.username = ? " +
                    "   r.utente = u.username";
            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("recensione") + " " + rs.getString("utente"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UtenteVia getUtenteCompleto(String username){
        UtenteVia utente = new UtenteVia();
        try{
            Statement st = connection.createStatement();
            String query = "select * from utenti where username = ?";
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                   utente.setUsername(rs.getString("username"));
                    utente.setEmail(rs.getString("email"));
                    utente.setNome(rs.getString("nome"));
                    utente.setCognome(rs.getString("cognome"));
                    utente.setVia(rs.getString("via"));
                    utente.setCivico(rs.getInt("civico"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }
}
