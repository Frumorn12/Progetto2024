package it.unical.informatica.progettobackend.controller;


import it.unical.informatica.progettobackend.persistenza.DBManager;
import it.unical.informatica.progettobackend.persistenza.dao.postgres.PiattoProxy;
import it.unical.informatica.progettobackend.persistenza.model.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class Servizi {

    @GetMapping ("/antipasti")

    public List<Piatto> dammiAntipasti(HttpServletRequest req){
        System.out.println("ENTRO DENTRO DAMMI ANTIPASTI");

        List<Piatto> piatti = DBManager.getInstance().getPiattiDao().findAllAntipasti();
        /*
        Piatto p1 = new Piatto(1, "Antipasto 1", "Descrizione 1");
        Piatto p2 = new Piatto(2, "Antipasto 2", "Descrizione 2");
        Piatto p3 = new Piatto(3, "Antipasto 3", "Descrizione 3");

        piatti.add(p1);
            piatti.add(p2);
            piatti.add(p3);
*/
        return piatti;




    }

    @GetMapping ("/primi")
    public List<Piatto> dammiPrimi(HttpServletRequest req){
        return dammiPiatti(req, 2);

    }

    @GetMapping ("/secondi")
    public List<Piatto> dammiSecondi(HttpServletRequest req){
        return dammiPiatti(req, 3);

    }

    @GetMapping ("/contorni")
    public List<Piatto> dammiContorni(HttpServletRequest req){
        return dammiPiatti(req, 4);

    }

    @GetMapping ("/dolci")
    public List<Piatto> dammiDolci(HttpServletRequest req){
        return dammiPiatti(req, 5);

    }

    @GetMapping ("/senzaLattosio")
    public List<Piatto> dammiSenzaLattosio(HttpServletRequest req){
        return dammiPiatti(req, 6);

    }

    @GetMapping ("/senzaGlutine")
    public List<Piatto> dammiSenzaGlutine(HttpServletRequest req){
        return dammiPiatti(req, 7);

    }

    @GetMapping ("/bevande")
    public List<Piatto> dammiBevande(HttpServletRequest req){
        return dammiPiatti(req, 8);

    }

    @GetMapping ("/preferitiPiatti")
    public List<Piatto> preferitiPiatti(HttpServletRequest req){
        System.out.println(req.getHeader("Authorization"));

        String auth = req.getHeader("Authorization");
        if (auth != null) {
            String token = auth.substring("Basic ".length());
            String username = Auth.getInstance().getUserByToken(token).getUsername();
            return DBManager.getInstance().getPreferitiDao().findAllPreferiti(username);
        }
        return null;

    }




    public List<Piatto> dammiPiatti(HttpServletRequest req, int tipo){
        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        String token = auth.substring("Basic ".length());
        System.out.println(token);
        //System.out.println(Auth.decodificaBase64(token));
        //String credenziali= Auth.decodificaBase64(token);
        //String [] creds = credenziali.split(":");
        //String username = creds[0];
        //String password = creds[1];
        //Utente utente = DBManager.getInstance().getUtenteDao().findByPrimaryKey(username);
        //if (utente != null){
        //    if (utente.getPassword().equals(password)){
        List<Piatto> migliori = null;

        switch (tipo) {
            case 1:
                migliori = DBManager.getInstance().getPiattiDao().findAllAntipasti();
                break;
            case 2:
                migliori = DBManager.getInstance().getPiattiDao().findAllPrimi();
                break;
            case 3:
                migliori = DBManager.getInstance().getPiattiDao().findAllSecondi();
                break;
            case 4:
                migliori = DBManager.getInstance().getPiattiDao().findAllContorni();
                break;
            case 5:
                migliori = DBManager.getInstance().getPiattiDao().findAllDolci();
                break;
            case 6:
                migliori = DBManager.getInstance().getPiattiDao().findAllSenzaLattosio();
                break;
            case 7:
                migliori = DBManager.getInstance().getPiattiDao().findAllSenzaGlutine();
                break;
            case 8:
                migliori = DBManager.getInstance().getPiattiDao().findAllBevande();
                break;

        }
        return migliori;
        //    }
        //}
        //return null;

    }

    @GetMapping ("/piatto_scelto/{name}")
    public Piatto dammiPiatto(HttpServletRequest req, @PathVariable String name){




        System.out.println("ENTRO DENTRO DAMMI PIATTO");
        Piatto piatto = DBManager.getInstance().getPiattiDao().getPiatto(name);

        piatto.PRINT();

        return piatto;
    }

    @GetMapping("/checkUtente/{username}")
    public boolean checkUtente(HttpServletRequest req, @PathVariable String username) {
        System.out.println("ENTRO DENTRO CHECK UTENTE");
        boolean b = DBManager.getInstance().getUtenteDao().checkUtente(username);
        return b;

    }

    @GetMapping("/getTipo/{username}")
    public int getTipo(HttpServletRequest req, @PathVariable String username) {
        System.out.println("ENTRO DENTRO Get TIPO");
        int b = DBManager.getInstance().getUtenteDao().getTipo(username);
        return b;

    }

    @PostMapping("/registrazione/{username}/{password}/{tipo}/{nome}/{cognome}/{data}/{via}/{civico}/{email}")
    public void registrazione(@PathVariable String username, @PathVariable String password , @PathVariable int tipo, @PathVariable String nome, @PathVariable String cognome, @PathVariable String data, @PathVariable String via, @PathVariable int civico, @PathVariable String email){

        DBManager.getInstance().getUtenteDao().addUtente(username, password, tipo, nome, cognome, data, via, civico, email);



        // Effettua l'operazione di registrazione utilizzando i parametri ricevuti
        /*
        DBManager.getInstance().getUtenteDao().addUtente(utente.getUsername(), utente.getPassword(), utente.getTipo(), utente.getNome(), utente.getCognome(), utente.getData(), utente.getVia(), utente.getCivico(), utente.getEmail());
         */
    }

    @PostMapping("/preferitiChange/{piatto}/{token}")
    public void preferitiChange(HttpServletRequest req,@PathVariable String piatto, @PathVariable String token){
        DBManager.getInstance().getPreferitiDao().changePreferiti(piatto, Auth.getInstance().getUserByToken(token).getUsername());


    }

    @GetMapping("/preferitiGet/{piatto}/{token}")
    public boolean preferitiGet(@PathVariable String piatto, @PathVariable String token){
        System.out.println("ENTRO DENTRO PREFERITI GET");

        boolean b = DBManager.getInstance().getPreferitiDao().getPreferiti(piatto, Auth.getInstance().getUserByToken(token).getUsername());

        System.out.println("Stato preferito: "+piatto + " "+ Auth.getInstance().getUserByToken(token).getUsername() + " " +  b );


        return b;
    }

    @GetMapping("/pushCarrello/{piatto}/{prezzo}/{token}")

    public boolean pushCarrello(HttpServletRequest req, @PathVariable String piatto, @PathVariable double prezzo, @PathVariable String token){
        System.out.println("ENTRO DENTRO GET CARRELLO");




        System.out.println("Stato carrello: "+piatto+ " "+ prezzo + Auth.getInstance().getUserByToken(token).getUsername() );
        DBManager.getInstance().getCarrelloDao().putInCarrello(Auth.getInstance().getUserByToken(token).getUsername(),piatto, prezzo);
        return true;

    }

    @GetMapping("/getCarrello/{token}")
    public List<Carrello> getCarrello(HttpServletRequest req, @PathVariable String token){
        System.out.println("ENTRO DENTRO GET CARRELLO");
        return DBManager.getInstance().getCarrelloDao().getCarrello(Auth.getInstance().getUserByToken(token).getUsername());}



    @GetMapping("/deleteCarrello/{piatto}/{token}")
    public boolean deleteCarrello(HttpServletRequest req, @PathVariable String piatto, @PathVariable String token){
        System.out.println("ENTRO DENTRO DELETE CARRELLO");
        DBManager.getInstance().getCarrelloDao().deleteFromCarrello(piatto, Auth.getInstance().getUserByToken(token).getUsername());
        return true;
    }

    @GetMapping("/ingredienti")
    public List<Ingredienti> getIngredienti(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getIngredienti();
    }

    @GetMapping("/base")
    public List<Ingredienti> getBase(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getBase();
    }

    @GetMapping("/carne")
    public List<Ingredienti> getCarne(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getCarne();
    }

    @GetMapping("/salsa")
    public List<Ingredienti> getSalsa(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getSalsa();
    }

    @GetMapping("/contorno1")
    public List<Ingredienti> getContorni(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getContorni();
    }



    @GetMapping("/bevande1")
    public List<Ingredienti> getBevande(HttpServletRequest req){
        return DBManager.getInstance().getHamburgerDao().getBevande();
    }

    @GetMapping("/addIngrediente/{nome}/{prezzo}/{token}")
    public boolean addIngrediente(HttpServletRequest req, @PathVariable String nome, @PathVariable double prezzo, @PathVariable String token){
        System.out.println("CIRO NAPOLETANO ORSO CINESE");
        return DBManager.getInstance().getHamburgerDao().addIngrediente(nome, prezzo, Auth.getInstance().getUserByToken(token).getUsername());
    }

    @GetMapping("/getHamburger")
    public List<Hamburger> getHamburger(HttpServletRequest req){
        System.out.println("SONO DENTRO GET HAMBURGER : " + Auth.getInstance().getUserByToken(req.getHeader("Authorization").substring("Basic ".length())).getUsername());
        return DBManager.getInstance().getHamburgerDao().getHamburger(Auth.getInstance().getUserByToken(req.getHeader("Authorization").substring("Basic ".length())).getUsername());
    }

    @GetMapping("/getAllUtente")
    public List<UtenteCompleto> getAllUtente(HttpServletRequest req){
        System.out.println("SONO DENTRO GET ALL UTENTE : " + Auth.getInstance().getUserByToken(req.getHeader("Authorization").substring("Basic ".length())).getUsername());
        return DBManager.getInstance().getUtenteDao().getAllUtente();
    }

    @GetMapping("/changeTipo/{username}/{tipo}")
    public boolean changeTipo(HttpServletRequest req, @PathVariable String username, @PathVariable int tipo){
        return DBManager.getInstance().getUtenteDao().changeTipo(username, tipo);
    }


    @GetMapping("/getSearch/{stringa}")
    public List<Piatto> getSearch(HttpServletRequest req, @PathVariable String stringa){
        System.out.println("SONO DENTRO GET SEARCH : " + stringa);
        return DBManager.getInstance().getPiattiDao().getSearch(stringa);
    }


    @GetMapping("/recensioneAdd/{piatto}/{recensione}")
    public boolean addRecensione(HttpServletRequest req, @PathVariable String piatto, @PathVariable String recensione){

        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        String token = auth.substring("Basic ".length());
        return DBManager.getInstance().getRecensioneDao().addRecensione( Auth.getInstance().getUserByToken(token).getUsername(),piatto, recensione);

    }

    @GetMapping("/getRecensito/{piatto}")
    public boolean getRecensito(HttpServletRequest req, @PathVariable String piatto){

        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        String token = auth.substring("Basic ".length());
        return DBManager.getInstance().getRecensioneDao().getRecensito( Auth.getInstance().getUserByToken(token).getUsername(),piatto);

    }

    @GetMapping("/getRecensione/{piatto}")
    public Recensione getRecensione(HttpServletRequest req, @PathVariable String piatto){

        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        String token = auth.substring("Basic ".length());

        System.out.println("SONO DENTRO GET RECENSIONE : " + Auth.getInstance().getUserByToken(token).getUsername());

        String recensione = DBManager.getInstance().getRecensioneDao().getRecensione( Auth.getInstance().getUserByToken(token).getUsername(),piatto);
        System.out.println("RECENSIONE: " + recensione);
        Recensione recensione1 = new Recensione(recensione);
        return recensione1;
    }

    @GetMapping("/immagini")
    public List<Immagine> getImmagini(HttpServletRequest req){
        String auth = req.getHeader("Authorization");
        System.out.println(auth);
        String token = auth.substring("Basic ".length());

        return DBManager.getInstance().getHamburgerDao().getImmagine(Auth.getInstance().getUserByToken(token).getUsername());
    }


    @GetMapping("/getRecensione")
    public List<RecensioneCompleta> getRecensione(HttpServletRequest req){
        return DBManager.getInstance().getRecensioneDao().getRecensioni();
    }

    @GetMapping("/prenota/{data}/{consegna}")
    public void prenota(HttpServletRequest req, @PathVariable String data, @PathVariable boolean consegna){
        String auth = req.getHeader("Authorization");
        String token = auth.substring("Basic ".length());

        DBManager.getInstance().getCarrelloDao().prenota(Auth.getInstance().getUserByToken(token).getUsername(), data, consegna);

    }

    @GetMapping("/prenota_hamburger/{data}/{consegna}")
    public void prenota_hamburger(HttpServletRequest req, @PathVariable String data, @PathVariable boolean consegna){
        String auth = req.getHeader("Authorization");
        String token = auth.substring("Basic ".length());

        DBManager.getInstance().getCarrelloDao().prenota_hamburger(Auth.getInstance().getUserByToken(token).getUsername(), data, consegna);

    }

    @GetMapping("/ordini")
    public List<Ordine> getOrdini(HttpServletRequest req){
        String auth = req.getHeader("Authorization");
        String token = auth.substring("Basic ".length());
        int tipo = Auth.getInstance().getUserByToken(token).getTipo();
        return DBManager.getInstance().getOrdiniDao().findAll(Auth.getInstance().getUserByToken(token).getUsername(), tipo);
    }

    @PostMapping("/segnalaci/{richiesta}/{nome}/{cognome}/{email}/{commenti}")
    public void segnalaci(HttpServletRequest req, @PathVariable String richiesta, @PathVariable String nome, @PathVariable String cognome, @PathVariable String email, @PathVariable String commenti){
        System.out.println("SONO DENTRO SEGNALACI");
        DBManager.getInstance().getUtenteDao().segnalaci(richiesta,nome,cognome,email,commenti);
    }

    @DeleteMapping("/ricette/{nomeRicetta}")
    public ResponseEntity<?> eliminaRicetta(@PathVariable String nomeRicetta) {
        DBManager.getInstance().getPiattiDao().deletePiatto(nomeRicetta);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/ricette")
    public void aggiungiRicetta(
            @RequestParam("nome_piatto") String nomePiatto,
            @RequestParam("ingredienti_piatto") String ingredientiPiatto,
            @RequestParam("descrizione_piatto") String descrizionePiatto,
            @RequestParam("preparazione_piatto") String preparazionePiatto,
            @RequestParam("tipo_piatto") String tipoPiatto,
            @RequestParam("immagine_piatto") String immaginePiatto,
            @RequestParam("prezzo_piatto") double prezzoPiatto
    ){
        DBManager.getInstance().getPiattiDao().aggiungiPiatto(nomePiatto, ingredientiPiatto, descrizionePiatto, preparazionePiatto, Integer.parseInt(tipoPiatto), immaginePiatto, prezzoPiatto);
    }

    @GetMapping("/prenotazioni/date")
    public List<String> getPrenotazioni(HttpServletRequest req){
        return DBManager.getInstance().getPrenotazioniDao().getDate();
    }

    @PostMapping("/prenotazioni/tavola/{nome}/{cognome}/{numero}/{email}/{data}/{commenti}")
    public void aggiungiPrenotazione(@PathVariable String nome, @PathVariable String cognome, @PathVariable String numero, @PathVariable String email, @PathVariable String data, @PathVariable String commenti, HttpServletRequest req){
        String auth = req.getHeader("Authorization");
        String token = auth.substring("Basic ".length());
        DBManager.getInstance().getPrenotazioniDao().aggiungiPrenotazione(nome, cognome, numero, email, data, commenti, Auth.getInstance().getUserByToken(token).getUsername());
    }

    @GetMapping("/prenotazioni/tutte")
    public List<Prenotazione> getPrenotazioniTutte(HttpServletRequest req){
        return DBManager.getInstance().getPrenotazioniDao().getPrenotazioni();
    }

    @PostMapping("/prenotazioni/accetta/{id}")
    public void accettaPrenotazione(@PathVariable int id){
        DBManager.getInstance().getPrenotazioniDao().accettaPrenotazione(id);
    }

    @PostMapping("/prenotazioni/rifiuta/{id}")
    public void rifiutaPrenotazione(@PathVariable int id){
        DBManager.getInstance().getPrenotazioniDao().rifiutaPrenotazione(id);
    }

    @GetMapping("/prenotazioni/utente")
    public List<Prenotazione> getPrenotazioniUtente(HttpServletRequest req){
        String auth = req.getHeader("Authorization");
        String token = auth.substring("Basic ".length());
        return DBManager.getInstance().getPrenotazioniDao().getPrenotazioniUtente(Auth.getInstance().getUserByToken(token).getUsername());
    }



}

























