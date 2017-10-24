package com.aleksandarvasilevski.news.repository.network;

import com.aleksandarvasilevski.news.repository.network.model.News;


import retrofit2.Call;
import retrofit2.http.GET;

public interface IRestService {

    @GET("/v1/articles?source=google-news&sortBy=top&apiKey=182f7eaaa40c487abe388ac68f15f648")
    Call<News> getNews();
}
