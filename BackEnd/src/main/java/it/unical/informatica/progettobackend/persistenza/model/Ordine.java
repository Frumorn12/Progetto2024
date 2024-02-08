package it.unical.informatica.progettobackend.persistenza.model;

public class Ordine {
    String utente;
    String nome;
    int quantita;
    double prezzo;
    String data;

    int id;

    public Ordine(String utente, String nome, int quantita, double prezzo, String data, int id) {
        this.utente = utente;
        this.nome = nome;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.data = data;
        this.id = id;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

