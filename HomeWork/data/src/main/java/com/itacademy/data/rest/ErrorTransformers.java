package com.itacademy.data.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import retrofit2.HttpException;

public class ErrorTransformers {

    private Gson gson;

    @Inject
    public ErrorTransformers(Gson gson){
        this.gson = gson;
    }

    //метод для передачи ошибки в Compose
    @Singleton
    public <Model, ErrorTrowable extends Erorr> ObservableTransformer<Model, Model> parseHttpError() {

        return new ObservableTransformer<Model, Model>(){

            //сюда приходит Observable из RestService для подмены ошибки на свою
            @Override
            public ObservableSource<Model> apply(Observable<Model> upstream) {

                return upstream.onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Model>>() {
                    @Override
                    public ObservableSource<? extends Model> apply(Throwable throwable) throws Exception {

                        if (throwable instanceof SocketTimeoutException) {

                            return Observable.error(new Erorr(ErrorType.SERVER_NOT_AVAILABLE));

                        } else if (throwable instanceof IOException){

                            return Observable.error(new Erorr(ErrorType.NO_INTERNET));

                        } else if (throwable instanceof HttpException) {

                            HttpException httpException = (HttpException) throwable;
                            String bodyError = (String) httpException.response().body();

                            Type errorType = new TypeToken<ErrorTrowable>(){}.getType();
                            ErrorTrowable trowable = gson.fromJson(bodyError, errorType);

                            return Observable.error(trowable);
                        } else {

                            return Observable.error(new Erorr(ErrorType.UNKNOWN));
                        }
                    }
                });

            }
        };
    }
}
