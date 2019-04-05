package com.huxley.newyorktimes.utils;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.huxley.newyorktimes.client.AppClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import com.huxley.newyorktimes.listeners.DataLoadListener;
import com.huxley.newyorktimes.models.ApiResponse;
import com.huxley.newyorktimes.models.NewsItem;

public class Data {
    private static List<NewsItem> allNewsDataLst = new ArrayList<>();
    private static DataLoadListener mDataLoad;

    public static List<NewsItem> getAllNewsDataLstLst() {
        return allNewsDataLst;
    }

    //load all News
    public static void loadNewsData(int period, final DataLoadListener dataLoadListener, final AppCompatActivity activity) {
        AppClient.getClient().getAllNews(period + ".json", Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApiResponse apiResponse) {
                        allNewsDataLst = apiResponse.getResults();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {
                        dataLoadListener.onDataLoadCompleted();
                    }
                });
    }
}
