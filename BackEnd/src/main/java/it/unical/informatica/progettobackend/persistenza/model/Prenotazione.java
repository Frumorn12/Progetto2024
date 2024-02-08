package it.unical.informatica.progettobackend.persistenza.model;

public class Prenotazione {
    String nome;
    String cognome;
    String telefono;
    String email;
    String data;
    String commenti;
    String utente;
    boolean accettato;
    boolean rifiutato;

    int id;

    public Prenotazione(String nome, String cognome, String telefono, String email, String data, String commenti, String utente, boolean accettato, boolean rifiutato, int id) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.data = data;
        this.commenti = commenti;
        this.utente = utente;
        this.accettato = accettato;
        this.rifiutato = rifiutato;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCommenti() {
        return commenti;
    }

    public void setCommenti(String commenti) {
        this.commenti = commenti;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public boolean isAccettato() {
        return accettato;
    }

    public void setAccettato(boolean accettato) {
        this.accettato = accettato;
    }

    public boolean isRifiutato() {
        return rifiutato;
    }

    public void setRifiutato(boolean rifiutato) {
        this.rifiutato = rifiutato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
