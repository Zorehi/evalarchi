package fr.polytech.model;

import fr.polytech.dao.ArticleDAO;
import fr.polytech.dao.ArticleDAOImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartBean implements Serializable {
    // Utilisation d'une Map pour stocker les ArticleBeans avec leur quantité respective
    private List<ArticleTaken> cart;
    private Double totalPrice;

    // Méthode pour obtenir la liste des ArticleBeans dans le panier avec leur quantité
    public List<ArticleTaken> getContenuPanier() {
        return cart;
    }

    public void setCart(List<ArticleTaken> _cart) {
        cart = _cart;
    }

    public Double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(Double _totalPrice) { totalPrice = _totalPrice; }
}


