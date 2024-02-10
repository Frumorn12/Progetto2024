package it.unical.informatica.progettobackend;

import it.unical.informatica.progettobackend.controller.Auth;
import it.unical.informatica.progettobackend.persistenza.DBManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServletUtil {

    // Questo metodo gestisce le richieste relative alle viste
    @RequestMapping(value = "/views/**", method = {RequestMethod.GET, RequestMethod.POST})
    public String templateHandler(HttpServletRequest request) {
        // Ottieni il percorso della risorsa richiesta
        String resource = request.getRequestURI().substring("/views/".length());

        // Stampa il percorso della risorsa a scopo di debug
        System.out.println(resource);

        // Rimuovi l'estensione .html dal percorso della risorsa
        resource = resource.substring(0, resource.indexOf(".html"));

        // Restituisci il nome della risorsa senza estensione
        return resource;
    }

}
