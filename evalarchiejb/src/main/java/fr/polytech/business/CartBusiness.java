package fr.polytech.business;

import fr.polytech.model.ArticleBean;
import fr.polytech.model.CartBean;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CartBusiness {
    public Double computePrice(CartBean cart);

    public  void addItem(CartBean cart, int id);
    public  void popItem(CartBean cart, int id);

    public CartBean BuildCart();

}
