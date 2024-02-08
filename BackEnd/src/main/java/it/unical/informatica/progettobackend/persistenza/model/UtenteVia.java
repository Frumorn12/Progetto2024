package it.unical.informatica.progettobackend.persistenza.model;

public class UtenteVia {
    String username;
    String nome;
    String cognome;
    String email;
    String via;
    int civico;

    public UtenteVia(String username, String nome, String cognome, String email, String via, int civico) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.via = via;
        this.civico = civico;
    }

    public  UtenteVia() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }
}
