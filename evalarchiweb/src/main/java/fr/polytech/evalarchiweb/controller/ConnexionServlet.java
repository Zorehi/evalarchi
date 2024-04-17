package fr.polytech.evalarchiweb.controller;

import fr.polytech.business.UserBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "connexion", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

    @Inject
    private UserBusiness userBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("FAILED", false);

        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userBusiness.login(login, password)) {
            session.setAttribute("login", login);
            resp.sendRedirect("listarticles");
            return;
        }

        req.setAttribute("FAILED", true);
        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }
}
