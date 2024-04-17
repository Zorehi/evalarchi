package fr.polytech.model;

import java.io.Serializable;

public class ArticleTaken implements Serializable {
    private ArticleBean article;
    private Integer nbTaken;

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public Integer getNbTaken() {
        return nbTaken;
    }

    public void setNbTaken(Integer nbTaken) {
        this.nbTaken = nbTaken;
    }
}
