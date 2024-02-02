package it.unical.informatica.progettobackend.controller.servlet;


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
import java.util.Vector;

@WebServlet("/piatti/diammiPiatti")
public class PiattiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ENTRO DENTRO PIATTI SERVLET");
        List<Piatto> piatto =
                DBManager.getInstance().getPiattiDao().findAll();
        for (Piatto p : piatto){
            System.out.println(p.getNome());
        }
        req.setAttribute("lista_piatti", piatto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/piatti.html");
        dispatcher.forward(req, resp);
    }
}


