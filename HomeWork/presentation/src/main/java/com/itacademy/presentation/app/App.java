package com.itacademy.presentation.app;


import android.app.Application;

import com.itacademy.presentation.injection.AppComponent;
import com.itacademy.presentation.injection.AppModule;
import com.itacademy.presentation.injection.DaggerAppComponent;

public class App extends Application{

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
