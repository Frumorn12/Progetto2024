package it.unical.informatica.progettobackend.controller;

import it.unical.informatica.progettobackend.persistenza.DBManager;
import it.unical.informatica.progettobackend.persistenza.model.Utente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class Auth {

    private Auth(){

    }

    static Auth instance = null;

    public static Auth getInstance(){
        if(instance == null){
            instance = new Auth();
        }
        return instance;
    }
    private class AuthToken{
        String token;
        Utente utente;


        public Utente getUtente() {
            return utente;
        }
        public void setUtente(Utente utente) {
            this.utente = utente;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }


    }

    @PostMapping("/login")
    public AuthToken login(@RequestBody Utente utente, HttpServletRequest req) throws Exception{
        String username = utente.getUsername();
        String password = utente.getPassword();
        String concat = username + ":" + password;
        String token = codificaBase64(concat);
        utente = getUserByToken(token);
        if (utente != null){
            HttpSession session = req.getSession();
            session.setAttribute("user", utente);
            AuthToken auth = new AuthToken();
            auth.setToken(token);
            auth.setUtente(utente);
            return auth;
        }
        return null;
    }


    @PostMapping("/logout")
    public boolean logout(@RequestBody Utente utente, HttpServletRequest req) throws Exception{
        return true;
    }

    @PostMapping("/isAuthenticatedAsUser")
    public boolean isAuthenticatedAsUser(HttpServletRequest req){
        System.out.println("Chiama");
        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        if (auth != null){
            String token = auth.substring("Basic ".length());
            Utente utente = getUserByToken(token);
            if (utente != null){
                return utente.getTipo() == 1;
            }
            else {
                return false;
            }
        }else{
            return false;
        }
    }




    @GetMapping ("/isAuthenticatedAsAdmin")
    public boolean isAuthenticatedAsAdmin(HttpServletRequest req){
        System.out.println("Chiama admin");
        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        if (auth != null){
            String token = auth.substring("Basic ".length());
            Utente utente = getUserByToken(token);
            if (utente != null){
                return utente.getTipo() == 2;
            }
            else {
                return false;
            }
        }else{
            return false;
        }
    }



    @GetMapping("/getUserByToken/{token}")
    public String getUserByToken1(HttpServletRequest req, @PathVariable String token){
        System.out.println("TOKEN RICEVUTO: " + token);


        Utente utente = getUserByToken(token);
        if (utente != null){
            System.out.println("STAMPO USER: " + utente.getUsername());

            return utente.getUsername();
        }
        else {
            System.out.println("UTENTE NULL");
            return null;
        }


    }

    @GetMapping("/printList")
    public boolean printList(){
        System.out.println("STAMPO LISTA");
        DBManager.getInstance().getUtenteDao().getAllRec();
        return true;
    }
    public Utente getUserByToken(String token){


        if (token != null) {
            String decod = decodificaBase64(token);
            String username = decod.split(":")[0];
            String password = decod.split(":")[1];
            System.out.println("USERNAME: " + username);

            Utente utente = DBManager.getInstance().getUtenteDao().findByPrimaryKey(username);
            if (utente != null) {
                if (utente.getPassword().equals(password)) {

                    return utente;
                }
            }
        }
        return null;
    }

    private String codificaBase64(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    private static String decodificaBase64(String value){
        return new String(Base64.getDecoder().decode(value.getBytes()));
    }
}
