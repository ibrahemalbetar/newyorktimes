package com.huxley.newyorktimes.activities.spalsh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.huxley.newyorktimes.R;
import com.huxley.newyorktimes.activities.main.MainActivity;

public class SpalshActivity extends AppCompatActivity implements SpalshView {

    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        // initialize presenter to load all data
        presenter = new SplashPresenter(this, SpalshActivity.this);
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
