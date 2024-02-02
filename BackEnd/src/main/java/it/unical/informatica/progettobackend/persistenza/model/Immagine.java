package it.unical.informatica.progettobackend.persistenza.model;

public class Immagine {
    String immagine ;

    public Immagine(String immagine) {
        this.immagine = immagine;
    }

    public String getImmagine() {
        return immagine;
    }
    public void print(){
        System.out.println("Immagine: " + immagine);
    }

}
