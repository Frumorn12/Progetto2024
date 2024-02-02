package it.unical.informatica.progettobackend.persistenza.dao;



import it.unical.informatica.progettobackend.persistenza.model.Utente;

import java.util.List;

public interface UtenteDao {
    public List<Utente> findAll();

    public Utente findByPrimaryKey(String username);

    public void saveOrUpdate(Utente utente);

    public void delete(Utente utente);

    public boolean checkUtente(String username);

    public boolean addUtente(String username, String password, int tipo, String nome, String cognome, String data, String via, int civico, String email);
    int getTipo(String username);

    boolean changeTipo(String username, int tipo);
}
