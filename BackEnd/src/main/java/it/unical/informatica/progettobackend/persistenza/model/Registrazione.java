package it.unical.informatica.progettobackend.persistenza.model;

public class Registrazione {
    private String username;
    private String password;
    private int tipo;
    private String nome;
    private String cognome;
    private String data;
    private String via;
    private int civico;
    private String email;

    public Registrazione() {
    }

    public Registrazione(String username, String password, int tipo, String nome, String cognome, String data, String via, int civico, String email) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
        this.nome = nome;
        this.cognome = cognome;
        this.data = data;
        this.via = via;
        this.civico = civico;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getData() {
        return data;
    }

    public String getVia() {
        return via;
    }

    public int getCivico() {
        return civico;
    }

    public String getEmail() {
        return email;
    }

public void PRINT() {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("tipo: " + tipo);
        System.out.println("nome: " + nome);
        System.out.println("cognome: " + cognome);
        System.out.println("data: " + data);
        System.out.println("via: " + via);
        System.out.println("civico: " + civico);
        System.out.println("email: " + email);
    }

}
