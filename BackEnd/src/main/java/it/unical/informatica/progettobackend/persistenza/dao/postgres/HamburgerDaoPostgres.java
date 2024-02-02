package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.dao.HamburgerDao;
import it.unical.informatica.progettobackend.persistenza.model.Hamburger;
import it.unical.informatica.progettobackend.persistenza.model.Immagine;
import it.unical.informatica.progettobackend.persistenza.model.Ingredienti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HamburgerDaoPostgres implements HamburgerDao {

    //Tipo : Base = 1, Carne = 2, Salsa = 3, Ingredienti = 4

    Connection connection;

    public HamburgerDaoPostgres(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Ingredienti> getIngredienti() {
        try {
            List<Ingredienti> ingredienti = new ArrayList<>();
            String query = "SELECT * FROM ingredienti WHERE tipo = '4'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ingredienti.add(new Ingredienti(result.getString("nome"), result.getString("immagine"), result.getDouble("prezzo")));
            }
            return ingredienti;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Ingredienti> getBase() {
        try{
            List<Ingredienti> base = new ArrayList<>();
            String query = "SELECT * FROM ingredienti WHERE tipo = '1'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                base.add(new Ingredienti(result.getString("nome"), result.getString("immagine"), result.getDouble("prezzo")));
            }
            return base;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Ingredienti> getCarne() {
        try{
            List<Ingredienti> carne = new ArrayList<>();
            String query = "SELECT * FROM ingredienti WHERE tipo = '2'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                carne.add(new Ingredienti(result.getString("nome"), result.getString("immagine"), result.getDouble("prezzo")));
            }
            return carne;
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public List<Ingredienti> getSalsa() {
        try{
            List<Ingredienti> salsa = new ArrayList<>();
            String query = "SELECT * FROM ingredienti WHERE tipo = '3'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Ingredienti ingrediente = new Ingredienti(result.getString("nome"), result.getString("immagine"), result.getDouble("prezzo"));
                ingrediente.print();

                salsa.add(ingrediente);
                    }
            return salsa;
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public boolean addIngrediente(String nome, double prezzo, String utente) {
        try{
            if (getQuantita(utente, nome) > 0) {
                String query = "UPDATE hamburger SET quantita = quantita + 1 WHERE utente = ? and nome = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, utente);
                statement.setString(2, nome);
                statement.executeUpdate();
                return true;
            }
            else {
                String query = "INSERT INTO hamburger (utente, nome, prezzo, quantita) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, utente);
                statement.setString(2, nome);
                statement.setDouble(3, prezzo);
                statement.setInt(4, 1);
                statement.executeUpdate();
                return true;


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hamburger> getHamburger(String utente) {
        try{
            List<Hamburger> hamburger = new ArrayList<>();
            String query = "SELECT * FROM hamburger WHERE utente = ? ORDER BY ordine";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, utente);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                hamburger.add(new Hamburger(utente, result.getString("nome"), result.getDouble("prezzo"), result.getInt("quantita")));
            }
            return hamburger;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Immagine> getImmagine (String user) {
        List<Immagine> immagini = new ArrayList<>();

        try{
            List<Hamburger> hamburger = getHamburger(user);

            for (Hamburger h : hamburger) {
                String query = "SELECT * FROM ingredienti WHERE nome = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, h.getNome());
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    Immagine immagine = new Immagine(result.getString("immagine"));
                    immagini.add(immagine);

                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return immagini;

    }

    @Override
    public Immagine getImmagineSingola(String username, String nome) {
        try {


            String query = "SELECT * FROM ingredienti WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Immagine immagine = new Immagine(result.getString("immagine"));
                System.out.println("Username getImmagineSingola: " + username);
                System.out.println("Nome: " + nome);
                System.out.println("Immagine: " + immagine.getImmagine());
                System.out.println("ENTRO CON "+nome);

                return immagine;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int getQuantita (String username, String piatto) {
        try {
            String query = "select quantita from hamburger where utente = ? and nome = ?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, piatto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int quantita = rs.getInt("quantita");
                return quantita;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }



}
