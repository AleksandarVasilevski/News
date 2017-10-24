package com.aleksandarvasilevski.news.repository.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class News {

    public News(ArrayList<Article> article){
        this.article = article;
    }

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("articles")
    @Expose
    private ArrayList<Article> article;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ArrayList<Article> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<Article> article) {
        this.article = article;
    }
}
