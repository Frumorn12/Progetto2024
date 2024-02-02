package it.unical.informatica.progettobackend.persistenza.dao.postgres;
import it.unical.informatica.progettobackend.persistenza.dao.CarrelloDao;
import it.unical.informatica.progettobackend.persistenza.model.Carrello;

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
