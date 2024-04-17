package fr.polytech.model;

import java.io.Serializable;
import java.util.List;

public class CartBean implements Serializable {
    // Utilisation d'une Map pour stocker les ArticleBeans avec leur quantité respective
    private List<ArticleTaken> cart;
    private Double totalPrice;

    // Méthode pour obtenir la liste des ArticleBeans dans le panier avec leur quantité
    public List<ArticleTaken> getCart() {
        return cart;
    }

    public void setCart(List<ArticleTaken> _cart) {
        cart = _cart;
    }

    public Double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(Double _totalPrice) { totalPrice = _totalPrice; }
}


