package com.huxley.newyorktimes.activities.main;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.huxley.newyorktimes.R;
import com.huxley.newyorktimes.models.NewsItem;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    @BindView(R.id.list)
    RecyclerView list;
    private MainAdapter mainAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        presenter = new MainPresenter(this, MainActivity.this);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            presenter.updateNewsData(1);
            return true;
        }
        if (id == R.id.action_monthly_news) {
            presenter.updateNewsData(30);
            return true;
        }
        if (id == R.id.action_weekly_news) {
            presenter.updateNewsData(7);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showNewsList(List<NewsItem> newsItems) {
        mainAdapter = (MainAdapter) MainAdapter.newInstance(newsItems, this);
        list.setAdapter(mainAdapter);
    }

    @Override
    public void onNewsItemClicked(NewsItem newsItem) {
        presenter.goToDetailsScreen(this, newsItem);
    }

    @Override
    public void updateNewsData() {

    }

    @Override
    public void showEmptyView() {
        list.setAdapter(EmptyAdapter.newInstance());
    }

    @Override
    public void showLoadingDialog() {
        dialog = ProgressDialog.show(this, "",
                getString(R.string.wait), true);
    }

    @Override
    public void hideLoadingDialog() {
        dialog.hide();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        dialog.dismiss();
        super.onDestroy();
    }
}

