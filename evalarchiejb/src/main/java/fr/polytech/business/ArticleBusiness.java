package fr.polytech.business;

import fr.polytech.model.ArticleBean;

import java.awt.geom.Arc2D;
import java.util.List;

public interface ArticleBusiness {

    public List<ArticleBean> getAllArticles();

    public ArticleBean findArticleById(int id);
}
