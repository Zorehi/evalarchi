package fr.polytech.evalarchiweb.controller;

import fr.polytech.business.CartBusiness;
import fr.polytech.business.UserBusiness;
import fr.polytech.model.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="Cart", urlPatterns = {"/cartbean"})
public class CartBeanServlet extends HttpServlet {
    @Inject
    private CartBusiness cartBusiness;
    @Inject
    private UserBusiness userBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String)session.getAttribute("login");
        CartBean cart = (CartBean)session.getAttribute("CART");
        if (login == null) resp.sendRedirect("connexion");

        req.setAttribute("USER", userBusiness.findByLogin(login));
        req.setAttribute("CART", cart.getCart());
        req.setAttribute("TOTALPRICE", cartBusiness.computePrice(cart));

        req.getRequestDispatcher("cartbean.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
