package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Hamburger;
import it.unical.informatica.progettobackend.persistenza.model.Immagine;
import it.unical.informatica.progettobackend.persistenza.model.Ingredienti;
import it.unical.informatica.progettobackend.persistenza.model.Utente;

import java.util.List;

public interface HamburgerDao {
    List<Ingredienti> getIngredienti();
    List<Ingredienti> getBase();

    List<Ingredienti> getCarne();

    List<Ingredienti> getSalsa();


    boolean addIngrediente(String nome, double prezzo, String utente);

    List<Hamburger> getHamburger(String utente); //ritorna la lista di hamburger di un utente


    List<Immagine> getImmagine(String user);

    Immagine getImmagineSingola(String username, String nome);

    List<Ingredienti> getContorni();

    List<Ingredienti> getBevande();
}
