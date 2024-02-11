package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Prenotazione;
import it.unical.informatica.progettobackend.persistenza.model.Segnalazione;

import java.util.List;

public interface PrenotazioniDao {
    public List<String> getDate(); // get all the dates of the reservations

    void aggiungiPrenotazione(String nome, String cognome, String numero, String email, String data, String commenti, String username);

    List<Prenotazione> getPrenotazioni();

    void accettaPrenotazione(int id);

    void rifiutaPrenotazione(int id);

    List<Prenotazione> getPrenotazioniUtente(String username);

    List<Segnalazione> getSegnalazioni();
}
