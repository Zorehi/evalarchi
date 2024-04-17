package fr.polytech.dao;

import fr.polytech.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class ArticleDAOImpl implements ArticleDAO {

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "GestionArticle")
    private EntityManager em;

    @Override
    public List<ArticleBean> getListArticle() {
        Query requete = em.createNativeQuery("select * from ARTICLE", ArticleBean.class);
        return requete.getResultList();
    }

}
