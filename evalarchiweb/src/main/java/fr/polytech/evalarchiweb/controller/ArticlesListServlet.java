package fr.polytech.evalarchiweb.controller;

import fr.polytech.business.ArticleBusiness;
import fr.polytech.business.ArticleBusinessImpl;
import fr.polytech.business.CartBusiness;
import fr.polytech.business.CartBusinessImpl;
import fr.polytech.dao.ArticleDAO;
import fr.polytech.dao.ArticleDAOImpl;
import fr.polytech.model.ArticleBean;
import fr.polytech.model.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="ListArticles", urlPatterns = {"/listarticles"})
public class ArticlesListServlet extends HttpServlet {
    @Inject
    private ArticleBusiness articleBusiness;
    @Inject
    private CartBusiness cartBusiness;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = (String)session.getAttribute("login");
        if(login == null) resp.sendRedirect("connexion");

        CartBean cartBean = (CartBean) session.getAttribute("CART");
        if (cartBean== null){
            cartBean = cartBusiness.BuildCart();
        }
        session.setAttribute("CART",cartBean);
        req.setAttribute("CART", cartBean);

        req.getRequestDispatcher("listarticles.jsp").forward(req, resp);
    }


}
