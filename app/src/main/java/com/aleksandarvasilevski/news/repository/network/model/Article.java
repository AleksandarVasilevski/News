package com.aleksandarvasilevski.news.repository.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    public Article(String title, String description){
        this.title = title;
        this.description = description;
    }

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
