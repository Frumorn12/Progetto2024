package it.unical.informatica.progettobackend.persistenza.dao.postgres;



import it.unical.informatica.progettobackend.persistenza.dao.PiattoDao;
import it.unical.informatica.progettobackend.persistenza.model.Piatto;
import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PiattoDaoPostgres implements PiattoDao {
    Connection connection;

    public PiattoDaoPostgres(Connection connection){
        this.connection = connection;
    }


    @Override
    public List<Piatto> findAllNonEfficiente() {
        List<Piatto> piattiLista = new ArrayList<Piatto>();
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatto";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Piatto piatto = findByPrimaryKey(rs.getLong("id"));
                piattiLista.add(piatto);
            }
        } catch (SQLException e) {
                 e.printStackTrace();
        }

        return piattiLista;
    }

    public List<Piatto> findAllLazy() {
        List<Piatto> piattiLista = new ArrayList<Piatto>();


        return piattiLista;
    }
    @Override
    public List<Piatto> findAll() {
        List<Piatto> piattiLista = new ArrayList<Piatto>();
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Piatto piatto = new PiattoProxy(connection);
                piatto.setNome(rs.getString("nome"));
                piatto.setDescrizione(rs.getString("descrizione"));
                piatto.setIngredienti(rs.getString("ingredienti"));
                piatto.setPreparazione(rs.getString("preparazione"));
                piatto.setTipo(rs.getInt("tipo"));
                piatto.setImmagine(rs.getString("immagine"));
                piatto.setPrezzo(rs.getDouble("prezzo"));


                piattiLista.add(piatto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return piattiLista;
    }

    @Override
    public Piatto findByPrimaryKey(Long id) {
        Piatto piatto = null;

        return piatto;
    }

    @Override
    public void saveOrUpdate(Piatto piatto) {

    }

    @Override
    public void delete(Piatto piatto) {
        String query = "DELETE FROM piatto WHERE nome = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, piatto.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Piatto> findAllAntipasti() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '1'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllPrimi() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '2'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Piatto> findAllSecondi() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '3'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllContorni() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '4'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllDolci() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '5'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllSenzaLattosio() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '6'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllSenzaGlutine() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '7'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> findAllBevande() {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where tipo = '8'";

            ResultSet rs = st.executeQuery(query);

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Piatto getPiatto(String name) {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where nome = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            Piatto piatto = new PiattoProxy(connection);
            while (rs.next()) {
                piatto.setNome(rs.getString("nome"));
                piatto.setDescrizione(rs.getString("descrizione"));
                piatto.setIngredienti(rs.getString("ingredienti"));
                piatto.setPreparazione(rs.getString("preparazione"));
                piatto.setTipo(rs.getInt("tipo"));
                piatto.setImmagine(rs.getString("immagine"));
                piatto.setPrezzo(rs.getDouble("prezzo"));



            }
            return piatto;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Piatto> getSearch(String stringa) {
        try {
            Statement st = connection.createStatement();
            String query = "select * from piatti where nome like ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + stringa + "%");
            ResultSet rs = ps.executeQuery();

            List<Piatto> piatti = new ArrayList<>();
            while (rs.next()) {
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

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RecensioneCompleta> getRecensioni(PiattoProxy piattoProxy) {
        try {
            Statement st = connection.createStatement();
            String query = "select * from recensioni where piatto = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, piattoProxy.getNome());
            ResultSet rs = ps.executeQuery();

            List<RecensioneCompleta> recensioni = new ArrayList<>();
            while (rs.next()) {
                RecensioneCompleta recensione  = new RecensioneCompleta(rs.getString("recensione"), rs.getString("utente"), rs.getString("piatto"));
                recensioni.add(recensione);
            }

            return recensioni;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deletePiatto(String nomeRicetta) {
        try {
            String query = "DELETE FROM piatti WHERE nome = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nomeRicetta);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void aggiungiPiatto(String nomePiatto, String ingredientiPiatto, String descrizionePiatto, String preparazionePiatto, int tipoPiatto, String immaginePiatto, double prezzoPiatto) {
        try {
            String query = "INSERT INTO piatti (nome, ingredienti, descrizione, preparazione, tipo, immagine, prezzo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, nomePiatto);
            st.setString(2, ingredientiPiatto);
            st.setString(3, descrizionePiatto);
            st.setString(4, preparazionePiatto);
            st.setInt(5, tipoPiatto);
            st.setString(6, immaginePiatto);
            st.setDouble(7, prezzoPiatto);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
