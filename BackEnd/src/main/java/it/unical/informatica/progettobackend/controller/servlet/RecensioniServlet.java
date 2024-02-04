package it.unical.informatica.progettobackend.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unical.informatica.progettobackend.persistenza.model.Piatto;
import it.unical.informatica.progettobackend.persistenza.model.RecensioneCompleta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/mostraRecensione")

public class RecensioniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottieni il nome del piatto dalla richiesta

        List<RecensioneCompleta> recensioni = (List<RecensioneCompleta>) request.getAttribute("recensioni");
        request.setAttribute("recensioni", recensioni);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/recensioni.html");
        dispatcher.forward(request, response);


    }
}
