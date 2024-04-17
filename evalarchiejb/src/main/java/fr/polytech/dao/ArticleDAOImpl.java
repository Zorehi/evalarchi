package fr.polytech.dao;

import fr.polytech.evalarchi.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class ArticleDAOImpl implements fr.polytech.evalarchi.dao.ArticleDAO {

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "GestionNotes")
    private EntityManager em;
    @Override
    public void addArticle(ArticleBean article) {

    }

    @Override
    public void popArticle(ArticleBean article) {

    }

    @Override
    public List<ArticleBean> getListArticle() {
        Query requete = em.createNativeQuery("select * from ARTICLE", ArticleBean.class);
        return requete.getResultList();
    }

}
