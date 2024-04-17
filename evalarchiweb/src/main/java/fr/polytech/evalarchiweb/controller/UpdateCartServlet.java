package fr.polytech.evalarchiweb.controller;

import fr.polytech.business.ArticleBusiness;
import fr.polytech.dao.ArticleDAO;
import fr.polytech.model.CartBean;
import fr.polytech.model.ArticleBean;
import fr.polytech.business.CartBusiness;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="UpdateCartServlet", urlPatterns = {"/ajouterArticleAuPanier", "/retirerArticleDuPanier"})
public class UpdateCartServlet extends HttpServlet {

    @Inject
    private ArticleBusiness articleBusiness;
    @Inject
    private CartBusiness cartBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer le panier depuis la session
        HttpSession session = req.getSession();
        String login = (String)session.getAttribute("login");
        if(login == null) resp.sendRedirect("connexion");
        CartBean cart = (CartBean) session.getAttribute("CART");
        int idArticle =  Integer.parseInt(req.getParameter("article"));
        ArticleBean articleBean = articleBusiness.findArticleById(idArticle);
        // Récupérer l'action de l'utilisateur (ajouter ou retirer)
        String action = req.getRequestURI(); // Vous devrez peut-être ajuster cela en fonction de la structure de votre URL

        if (action.endsWith("ajouterArticleAuPanier"))
        {
            cartBusiness.addItem(cart, articleBean);
        } else if (action.endsWith("retirerArticleDuPanier"))
        {
            cartBusiness.popItem(cart, articleBean);
        }

        // Mettre à jour le panier dans la session
        session.setAttribute("CART", cart);

        // Rediriger vers la page listarticles.jsp pour rafraîchir la page avec les nouvelles valeurs
        resp.sendRedirect("listarticles");
    }
}
