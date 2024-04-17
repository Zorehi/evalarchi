package fr.polytech.dao;

import fr.polytech.model.ArticleBean;

import java.util.List;

public interface ArticleDAO {

    public List<ArticleBean> getListArticle();

    public ArticleBean findArticleById(int id);
}
