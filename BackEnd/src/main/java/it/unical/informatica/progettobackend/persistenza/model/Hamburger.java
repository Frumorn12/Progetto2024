package it.unical.informatica.progettobackend.persistenza.model;

public class Hamburger {
    String utente;
    String nome;
    double prezzo;
    int quantita;

    public Hamburger(String utente, String nome, double prezzo, int quantita) {
        this.utente = utente;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
