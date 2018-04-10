package com.itacademy.presentation.injection;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itacademy.data.repository.UserRepositoryImpl;
import com.itacademy.data.rest.RestApi;
import com.itacademy.data.rest.RestService;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserRepository;
import com.itacademy.presentation.BuildConfig;
import com.itacademy.presentation.executor.UIThread;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }

//    @Binds
//    public abstract PostExecutionThread getUiThread(UIThread uiThread);
// альтернативный метод передачи методов в Даггер. тоже самое что и сверху

    @Provides
    @Singleton
    public UserRepository getUserRepository(Context context, RestService restService) {
        return new UserRepositoryImpl(context, restService);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/8125A25A-18B7-D092-FFC9-22B2FB842700/8A0FDC45-8157-9553-FFFF-7CDF7394A100/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    //библиотека для настройки отправки или получения файлов в интернет
    public OkHttpClient getOkHttp(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);

        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor hli = new
                    HttpLoggingInterceptor();
            hli.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(hli);
        }
        return builder.build();
    }
}