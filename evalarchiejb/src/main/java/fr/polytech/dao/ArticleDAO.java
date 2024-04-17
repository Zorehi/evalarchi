package fr.polytech.dao;

import fr.polytech.evalarchi.model.ArticleBean;

import java.util.List;

public interface ArticleDAO {
    public void addArticle(ArticleBean article);

    public void popArticle(ArticleBean article);

    public List<ArticleBean> getListArticle();
}
