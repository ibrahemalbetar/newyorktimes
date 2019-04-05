package com.huxley.newyorktimes.activities.spalsh;

import android.support.v7.app.AppCompatActivity;

import com.huxley.newyorktimes.listeners.DataLoadListener;
import com.huxley.newyorktimes.utils.Data;

public class SplashPresenter implements DataLoadListener {

    SpalshView spalshView;

    public SplashPresenter(SpalshView spalshView, AppCompatActivity activity) {
        this.spalshView = spalshView;
        Data.loadNewsData(1, this, activity);
    }

    @Override
    public void onDataLoadCompleted() {
        spalshView.navigateToMain();
    }

    public void onDestroy() {
        spalshView = null;
    }
}
