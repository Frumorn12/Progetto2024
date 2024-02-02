package it.unical.informatica.progettobackend.persistenza.dao.postgres;



import it.unical.informatica.progettobackend.persistenza.dao.PiattoDao;
import it.unical.informatica.progettobackend.persistenza.model.Piatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
                Piatto piatto = (new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo")));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
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

            Piatto piatto = null;
            while (rs.next()) {
                piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"), rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));

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
                Piatto piatto = new Piatto(rs.getString("nome"), rs.getString("descrizione"), rs.getString("ingredienti"),
                        rs.getString("preparazione"), rs.getInt("tipo"), rs.getString("immagine"), rs.getDouble("prezzo"));
                piatto.PRINT();
                piatti.add(piatto);
            }

            return piatti;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
