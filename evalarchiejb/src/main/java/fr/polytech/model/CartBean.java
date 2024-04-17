package fr.polytech.model;

import fr.polytech.dao.ArticleDAO;
import fr.polytech.dao.ArticleDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartBean {
    // Utilisation d'une Map pour stocker les ArticleBeans avec leur quantité respective
    private Map<ArticleBean, Integer> Cart;
    private int TotalPrice;

    public CartBean() {
        Cart = new HashMap<>();
    }

    // Méthode pour obtenir la liste des ArticleBeans dans le panier avec leur quantité
    public Map<ArticleBean, Integer> getContenuPanier() {
        return Cart;
    }

    public void setCart(Map<ArticleBean, Integer> cart) {
        Cart = cart;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }
}


