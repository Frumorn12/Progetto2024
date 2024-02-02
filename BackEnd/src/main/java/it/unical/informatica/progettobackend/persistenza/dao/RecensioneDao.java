package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;

import java.util.List;

public interface RecensioneDao {

    boolean addRecensione(String username, String piatto, String recensione);

    boolean getRecensito(String username, String piatto);

    String getRecensione(String username, String piatto);

    List<RecensioneCompleta> getRecensioni();

}
