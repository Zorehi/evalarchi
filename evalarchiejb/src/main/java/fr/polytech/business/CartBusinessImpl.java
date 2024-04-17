package fr.polytech.business;

import fr.polytech.dao.ArticleDAO;
import fr.polytech.model.ArticleBean;
import fr.polytech.model.CartBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Map;

@Stateless
public class CartBusinessImpl implements CartBusiness {
    @Inject
    private ArticleDAO articleDAO;

    public double computePrice(CartBean cart){
        double prixTotal = 0.0;
        for (Map.Entry<ArticleBean, Integer> entry : cart.getContenuPanier().entrySet()) {
            ArticleBean article = entry.getKey();
            int quantite = entry.getValue();
            prixTotal += article.getPrice() * quantite;
        }
        return prixTotal;
    }

    @Override
    public void addItem(CartBean cart, ArticleBean article) {
        for (Map.Entry<ArticleBean, Integer> entry : cart.getContenuPanier().entrySet()) {
            ArticleBean articleList = entry.getKey();
            if(article.getId().equals(articleList.getId())){
                if(article.getNbRestant() > 0 ) {
                    article.setNbRestant(article.getNbRestant() - 1);
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
    }

    @Override
    public void popItem(CartBean cart, ArticleBean article) {
        for (Map.Entry<ArticleBean, Integer> entry : cart.getContenuPanier().entrySet()) {
            ArticleBean articleList = entry.getKey();
            if(article.getId().equals(articleList.getId())){
                if(entry.getValue() > 0 ) {
                    article.setNbRestant(article.getNbRestant() + 1);
                    entry.setValue(entry.getValue() - 1);
                }
            }
        }
    }

    @Override
    public CartBean BuildCart() {
        CartBean cart = new CartBean();
        for(ArticleBean article : articleDAO.getListArticle()){
            cart.getContenuPanier().put(article,0);
        }
        return cart;
    }

}
