package com.mijack.xposed;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * @author Mi&Jack
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
