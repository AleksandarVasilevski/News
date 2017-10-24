package com.aleksandarvasilevski.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.aleksandarvasilevski.news.repository.network.RestClient;
import com.aleksandarvasilevski.news.repository.network.model.Article;
import com.aleksandarvasilevski.news.repository.network.model.News;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;

    @BindView(R.id.rv_list) RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private NewsAdapter newsAdapter;
    ArrayList<News> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Buterknife binding
        ButterKnife.bind(this);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

//        list = new ArrayList<>();
        restResponse();
//        newsAdapter = new NewsAdapter(list);
//        recyclerView.setAdapter(newsAdapter);
    }

    public void restResponse(){
        Call<News> newsCall = new RestClient().getRestService().getNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                list = new ArrayList<>();
                Log.i("#LOG", response.body().getArticle().size() + "");
                for (int i = 0; i < response.body().getArticle().size(); i++){
                    list.add(new News(new ArrayList<Article>(response.body().getArticle())));
                }

                newsAdapter = new NewsAdapter(list);
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i("REST", "REST FAILED");
            }
        });
    }

    public void button(View view){
        restResponse();
    }
}
