package com.aleksandarvasilevski.news;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aleksandarvasilevski.news.repository.network.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static final String TAG = "NewsAdapter";
    private ArrayList<News> list;

    public NewsAdapter(ArrayList<News> list){
        this.list = list;
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV;
        private TextView descriptionTV;

        public ViewHolder(View itemView) {
            super(itemView);
            // Define click listener for the ViewHolder's View.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked");
                }
            });

            titleTV = (TextView) itemView.findViewById(R.id.tv_list_title);
            descriptionTV = (TextView) itemView.findViewById(R.id.tv_list_description);
        }

        public TextView getTitleTV(){
            return titleTV;
        }

        public TextView getDescriptionTV(){
            return descriptionTV;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        holder.getTitleTV().setText(list.get(position).getArticle().get(position).getTitle());
        holder.getDescriptionTV().setText(list.get(position).getArticle().get(position).getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager
    @Override
    public int getItemCount() {
        Log.i(TAG, "ArraySize: " + list.size());
        return list.size();
    }
}
