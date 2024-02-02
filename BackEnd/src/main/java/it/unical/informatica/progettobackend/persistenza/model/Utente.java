package it.unical.informatica.progettobackend.persistenza.model;

import java.util.Date;

public class Utente {

    private String username;
    private String password;
    private int tipo;



    public Utente() {
    }

    public Utente(String username, String password, int tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


}
