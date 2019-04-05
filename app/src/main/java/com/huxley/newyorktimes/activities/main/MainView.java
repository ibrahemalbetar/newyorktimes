package com.huxley.newyorktimes.activities.main;

import com.huxley.newyorktimes.models.NewsItem;

import java.util.List;


public interface MainView {
    public void showNewsList(List<NewsItem> newsItems);

    public void onNewsItemClicked(NewsItem newsItem);

    public void updateNewsData();

    public void showEmptyView();

    public void showLoadingDialog();

    public void hideLoadingDialog();
}
