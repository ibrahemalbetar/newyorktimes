package com.huxley.newyorktimes.activities.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huxley.newyorktimes.R;
import com.huxley.newyorktimes.models.NewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<NewsItem> newsItemList;
    private MainView view;

    public static RecyclerView.Adapter newInstance(List<NewsItem> NewsItems, MainView view) {
        return new MainAdapter(NewsItems, view);
    }

    private MainAdapter(List<NewsItem> newsItemList, MainView view) {
        this.newsItemList = newsItemList;
        this.view = view;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        int defaultHeight = newsItemList.get(0).getMedia().get(0).getMetadata().get(4).getHeight();
        itemView.setLayoutParams((new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, defaultHeight)));
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        final NewsItem newsItem = newsItemList.get(position);
        Picasso.get()
                .load(newsItem.getMedia().get(0).getMetadata().get(4).getUrl())
                .placeholder(R.color.white)
                .error(R.color.colorPrimary)
                .into(holder.icon);
        holder.title.setText(newsItem.getTitle());
        holder.byline.setText(newsItem.getByline());
        holder.postDate.setText(newsItem.getPublished_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onNewsItemClicked(newsItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }


    class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.byline)
        TextView byline;
        @BindView(R.id.date)
        TextView postDate;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
