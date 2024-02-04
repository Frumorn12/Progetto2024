package it.unical.informatica.progettobackend.persistenza.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Piatto {
    private String nome;

    private String ingredienti;

    private String descrizione;

    private String preparazione;

    private int tipo;

    private String immagine;

    private double prezzo;

    private List<RecensioneCompleta> recensioni;






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piatto piatto = (Piatto) o;
        return Objects.equals(nome, piatto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }






    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public String getPreparazione() {
        return preparazione;
    }

    public void setPreparazione(String preparazione) {
        this.preparazione = preparazione;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public List<RecensioneCompleta> getRecensioni() {
        return recensioni;
    }

    public void PRINT(){
        System.out.println("Nome: "+nome);
        System.out.println("Descrizione: "+descrizione);
        System.out.println("Ingredienti: "+ingredienti);
        System.out.println("Preparazione: "+preparazione);
        System.out.println("Tipo: "+tipo);
        System.out.println("Immagine: "+immagine);
        System.out.println("Prezzo: "+prezzo);
    }

    protected void setRecensioni(List<RecensioneCompleta> recs) {
        recensioni = recs;
    }
}
