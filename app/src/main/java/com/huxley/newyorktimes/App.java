package com.huxley.newyorktimes;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import com.google.android.libraries.places.api.Places;

public class App extends Application {
    // Called when the application is starting, before any other application objects have been created.
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
        context = this;
        // Initialize Places.
        //Places.initialize(this, getString(R.string.apiKey));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}