package com.itacademy.presentation.app;


import android.app.Application;

import com.itacademy.presentation.injection.AppComponent;
import com.itacademy.presentation.injection.AppModule;
import com.itacademy.presentation.injection.DaggerAppComponent;

public class App extends Application{

    private static AppComponent appComponent;//реализовываем интефейс AppComponent(там указаны классы
    //в которых необходимо произвести сборку объектов)
    //

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()//теперь указываем как собрать интефейс AppComponent
                .appModule(new AppModule(this))//как его собрать указано в AppModule
                .build();//в AppModule описывается как собирать классы интефейса AppComponent

    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
