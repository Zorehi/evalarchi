package fr.polytech.evalarchiweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="Cart", urlPatterns = {"/cartbean"})
public class CartBeanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String)session.getAttribute("login");
        if (login == null) resp.sendRedirect("connexion");

        req.setAttribute("USER", login);

        req.getRequestDispatcher("cartbean.jsp").forward(req, resp);
    }
}
