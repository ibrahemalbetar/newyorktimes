package com.huxley.newyorktimes.activities.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.huxley.newyorktimes.activities.main.MainView;
import com.huxley.newyorktimes.models.NewsItem;

public class DetailsPresenter {

    private DetailsView view;
    private Intent intent;

    public DetailsPresenter(AppCompatActivity activity, DetailsView view) {
        intent = activity.getIntent();
        this.view = view;
        NewsItem newsItem = intent.getParcelableExtra("newsItem");
        view.showNewsDetails(newsItem);
    }

    public void onDestroy() {
        view = null;
    }
}
