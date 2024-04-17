package fr.polytech.business;

import fr.polytech.dao.ArticleDAO;
import fr.polytech.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ArticleBusinessImpl implements ArticleBusiness{

    @Inject
    private ArticleDAO articleDAO;
    @Override
    public List<ArticleBean> getAllArticles() {
        return articleDAO.getListArticle();
    }

    @Override
    public ArticleBean findArticleById(int id) {
        return articleDAO.findArticleById(id);
    }
}
