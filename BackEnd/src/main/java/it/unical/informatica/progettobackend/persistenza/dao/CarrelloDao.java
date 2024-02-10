package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Carrello;

import java.util.List;

public interface CarrelloDao {

    void putInCarrello(String username, String piatto, double prezzo);

    void deleteFromCarrello(String piatto, String username);

    List<Carrello> getCarrello(String username);

    void prenota(String username,String data, boolean consegna);

    void prenota_hamburger(String username, String data, boolean consegna);
}
