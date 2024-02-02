package it.unical.informatica.progettobackend.persistenza.model;

public class RecensioneCompleta {
    String recensione;
    String username;
    String piatto;

    public RecensioneCompleta(String recensione, String username, String piatto) {
        this.recensione = recensione;
        this.username = username;
        this.piatto = piatto;
    }

    public String getRecensione() {
        return recensione;
    }

    public String getUsername() {
        return username;
    }

    public String getPiatto() {
        return piatto;
    }

}
