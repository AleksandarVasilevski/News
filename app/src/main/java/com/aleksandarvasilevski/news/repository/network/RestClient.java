package com.aleksandarvasilevski.news.repository.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static final String URL = "https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=182f7eaaa40c487abe388ac68f15f648";

    private IRestService restService;

    public RestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restService = retrofit.create(IRestService.class);
    }

    public IRestService getRestService(){
        return restService;
    }
}
