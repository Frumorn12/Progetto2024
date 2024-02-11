package it.unical.informatica.progettobackend.persistenza.model;

public class Segnalazione {
    String richiesta;
    String nome;
    String cognome;
    String  email;
    String commenti;

    public Segnalazione(String richiesta, String nome, String cognome, String email, String commenti) {
        this.richiesta = richiesta;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.commenti = commenti;
    }

    public String getRichiesta() {
        return richiesta;
    }

    public void setRichiesta(String richiesta) {
        this.richiesta = richiesta;
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

    public String getCommenti() {
        return commenti;
    }

    public void setCommenti(String commenti) {
        this.commenti = commenti;
    }
}
