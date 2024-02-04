package it.unical.informatica.progettobackend.persistenza.dao.postgres;

import it.unical.informatica.progettobackend.persistenza.model.Piatto;
import it.unical.informatica.progettobackend.persistenza.model.Recensione;
import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;

import java.sql.Connection;
import java.util.List;

public class PiattoProxy extends Piatto {
    Connection conn;

    public PiattoProxy(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<RecensioneCompleta> getRecensioni() {

        List<RecensioneCompleta> recs = super.getRecensioni();
        if (recs == null) {
            PiattoDaoPostgres dao = new PiattoDaoPostgres(conn);
            recs = dao.getRecensioni(this);

            System.out.println("Recensioni: " + recs.size());
            super.setRecensioni(recs);
            return recs;
        }else{
            return recs;
        }
    }

}
