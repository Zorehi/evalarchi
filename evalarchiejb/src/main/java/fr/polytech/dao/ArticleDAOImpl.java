package fr.polytech.dao;

import fr.polytech.model.ArticleBean;
import fr.polytech.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class ArticleDAOImpl implements ArticleDAO {

    // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
    @PersistenceContext(unitName = "Evalarchi")
    private EntityManager em;


    @Override
    public List<ArticleBean> getListArticle() {
        Query requete = em.createNativeQuery("select * from ARTICLE", ArticleBean.class);
        return requete.getResultList();
    }

    @Override
    public ArticleBean findArticleById(int id) {
        TypedQuery<ArticleBean> query = em.createQuery(
                "SELECT u FROM ArticleBean u WHERE u.id = :ID", ArticleBean.class);
        query.setParameter("ID", id);
        ArticleBean articleBean = query.getSingleResult();
        return  articleBean;
    }

}
