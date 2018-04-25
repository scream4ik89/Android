package com.itacademy.presentation.injection;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itacademy.data.dataBase.AppDataBase;
import com.itacademy.data.repository.UserProfieleRepositoryImpl;

import com.itacademy.data.rest.ErrorTransformers;
import com.itacademy.data.rest.RestApi;
import com.itacademy.data.rest.RestService;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.UserProfileRepository;

import com.itacademy.presentation.executor.UIThread;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.itacademy.presentation.constant.Constant.URL_FOR_RETROFIT;
import static com.itacademy.presentation.constant.Constant.URL_MY_RETROFIT;

@Module
public class AppModule {

    Context context;
    Retrofit retrofit;
    public static final String DATA_BASE_NAME = "database";

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton//что бы потом предоставить контекст в конструктор, необхдим метод
    //даггер будет во возвращаемому значению искать у себся в классе подходящий объект
    //так же необходимо пометить конструктор того класс который будет собран даггером анотацией
    //Inject
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    public UserProfileRepository getUserProfileRepository(RestService restService, AppDataBase appDataBase) {

        return new UserProfieleRepositoryImpl(restService, appDataBase);
    }

    @Provides
    @Singleton
    public RestService getRestService(RestApi restAPI, ErrorTransformers errorTransformers) {
        return new RestService(restAPI, errorTransformers);
    }

    @Provides
    @Singleton//будет создан объект ретрофит на базен нашего интерфейса(т.е. с нашей реализацией)
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.baseUrl("https://api.backendless.com/8125A25A-18B7-D092-FFC9-22B2FB842700/8A0FDC45-8157-9553-FFFF-7CDF7394A100/")
                .baseUrl(URL_FOR_RETROFIT)//Взять из билд конфиг
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
    public AppDataBase getAppDataBase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, DATA_BASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }
}
