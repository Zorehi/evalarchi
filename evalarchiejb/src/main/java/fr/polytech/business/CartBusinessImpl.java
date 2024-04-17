package fr.polytech.business;

import fr.polytech.dao.ArticleDAO;
import fr.polytech.dao.ArticleDAOImpl;
import fr.polytech.model.ArticleBean;
import fr.polytech.model.ArticleTaken;
import fr.polytech.model.CartBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@Stateless
public class CartBusinessImpl implements CartBusiness {
    @Inject
    private ArticleDAO articleDAO;

    public CartBusinessImpl(){
        this.articleDAO = new ArticleDAOImpl();
    }

    public Double computePrice(CartBean cart){
        double prixTotal = 0.0;
         for(ArticleTaken articleTaken : cart.getCart()){
             prixTotal += articleTaken.getArticle().getPrice()*articleTaken.getNbTaken();
         }
        return prixTotal;
    }

    @Override
    public void addItem(CartBean cart, int id) {
        for(ArticleTaken articleTaken : cart.getCart()){
            if(articleTaken.getArticle().getId() == id ){
                if (articleTaken.getArticle().getNbRestant() - articleTaken.getNbTaken() > 0){
                    articleTaken.setNbTaken(articleTaken.getNbTaken() + 1);
                }
            }
        }
    }

    @Override
    public void popItem(CartBean cart, int id) {
        for(ArticleTaken articleTaken : cart.getCart()){
            if(articleTaken.getArticle().getId() == id ){
                if (articleTaken.getNbTaken() > 0) {
                    articleTaken.setNbTaken(articleTaken.getNbTaken() - 1);
                }
            }
        }
    }

    @Override
    public CartBean BuildCart() {
        CartBean cart = new CartBean();
        for(ArticleBean article : articleDAO.getListArticle()){
            ArticleTaken articleTaken = new ArticleTaken();
            articleTaken.setArticle(article);
            articleTaken.setNbTaken(0);
            cart.getCart().add(articleTaken);
        }
        return cart;
    }

}
