package it.unical.informatica.progettobackend.controller.servlet;

import it.unical.informatica.progettobackend.controller.Auth;
import it.unical.informatica.progettobackend.persistenza.DBManager;
import it.unical.informatica.progettobackend.persistenza.model.Piatto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/piatti/diammiPiatti")
public class PiattiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ottieni il token dalla richiesta
        String token = req.getParameter("token");
        System.out.println("TOKEN: " + token);

        // Controlla se il token è nullo
        if (token == null) {
            // Se il token è nullo, restituisci uno status di "Unauthorized" e un messaggio di accesso negato
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Accesso negato. L'utente non è un amministratore.");
        } else if (Auth.getInstance().getUserByToken(token).getTipo() == 2) {
            // Se l'utente è autenticato e il suo tipo è 2 (presumibilmente un amministratore), procedi con la visualizzazione dei piatti

            System.out.println("ENTRO DENTRO PIATTI SERVLET");

            // Recupera la lista di piatti dal database
            List<Piatto> piatti = DBManager.getInstance().getPiattiDao().findAll();

            // Stampa i nomi dei piatti sulla console (per scopi di debug)
            for (Piatto p : piatti) {
                System.out.println(p.getNome());
            }

            // Imposta la lista di piatti come attributo della richiesta
            req.setAttribute("lista_piatti", piatti);

            // Ottieni il dispatcher per inoltrare la richiesta alla vista dei piatti
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/piatti.html");
            dispatcher.forward(req, resp);
        } else {
            // Se l'utente non è autorizzato (non è un amministratore), restituisci uno status di "Unauthorized" e un messaggio di accesso negato
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Accesso negato. L'utente non è un amministratore.");
        }
    }
}
