package it.unical.informatica.progettobackend.persistenza.model;

public class Ingredienti {
    String nome;
    String immagine;
    Double prezzo;


    public Ingredienti(String nome, String immagine, Double prezzo) {
        this.nome = nome;
        this.immagine = immagine;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }


    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public void print() {
    	System.out.println("Nome: " + nome + " Immagine: " + immagine + " Prezzo: " + prezzo);
    }
}
