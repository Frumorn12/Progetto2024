package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.model.Piatto;
import it.unical.informatica.progettobackend.persistenza.model.Recensione;
import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PiattoProxy extends Piatto {
    Connection conn;

    public PiattoProxy(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<RecensioneCompleta> getRecensioni() {

        List<RecensioneCompleta> recs = new ArrayList<>();

        if (super.getRecensioni() == null) {

            String query = "SELECT recensioni.* " +
                    "FROM piatti AS p " +
                    "JOIN recensioni ON p.nome = recensioni.piatto " +
                    "JOIN utenti ON recensioni.utente = utenti.username " +
                    "WHERE p.nome = ?";

            try{
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, getNome());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    RecensioneCompleta rec = new RecensioneCompleta(rs.getString("recensione"), rs.getString("utente") ,  rs.getString("piatto"));
                    recs.add(rec);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }

            System.out.println("Recensioni: " + recs.size());
            super.setRecensioni(recs);
            return recs;
        }else{
            return recs;
        }
    }

}
