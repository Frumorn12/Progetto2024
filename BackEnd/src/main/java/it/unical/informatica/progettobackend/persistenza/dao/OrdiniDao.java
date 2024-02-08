package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Ordine;

import java.sql.SQLException;
import java.util.List;

public interface OrdiniDao {
    public List<Ordine> findAll(String username, int tipo) ;
}
