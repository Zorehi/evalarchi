package fr.polytech.business;

import fr.polytech.model.ArticleBean;
import fr.polytech.model.CartBean;
import jakarta.ejb.Local;

@Local
public interface CartBusiness {
    public double computePrice(CartBean cart);

    public void addItem(CartBean cart, ArticleBean article);
    public void popItem(CartBean cart, ArticleBean article);

    public CartBean BuildCart();

}
