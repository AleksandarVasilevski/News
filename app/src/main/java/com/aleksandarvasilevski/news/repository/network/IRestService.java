package com.aleksandarvasilevski.news.repository.network;

import com.aleksandarvasilevski.news.repository.network.model.News;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface IRestService {

    @FormUrlEncoded
    @GET
    Call<News> getNews(@Field("title") String title, @Field("description") String description);
}
