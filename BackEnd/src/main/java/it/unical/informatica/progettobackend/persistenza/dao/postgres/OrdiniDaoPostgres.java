package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.controller.Auth;
import it.unical.informatica.progettobackend.persistenza.dao.OrdiniDao;
import it.unical.informatica.progettobackend.persistenza.model.Ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrdiniDaoPostgres implements OrdiniDao {
    Connection connection;

    public OrdiniDaoPostgres(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ordine> findAll(String username, int tipo) {
        List<Ordine> ordini = new ArrayList<>();

        if (tipo == 2){
            try{
                String query = "select * from prenotazione_asporto order by id,nome";
                PreparedStatement st = connection.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Ordine ordine = new Ordine(rs.getString("utente"),rs.getString("nome_"),rs.getInt("quantita"),rs.getDouble("prezzo"), rs.getString("data"), rs.getInt("id"));
                    ordini.add(ordine);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ordini;
        }
        try{
            String query = "select * from prenotazione_asporto where utente = ? order by id,nome";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Ordine ordine = new Ordine(rs.getString("utente"),rs.getString("nome_"),rs.getInt("quantita"),rs.getDouble("prezzo"), rs.getString("data"), rs.getInt("id"));
                ordini.add(ordine);
            }
            return ordini;



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordini;

    }

}
