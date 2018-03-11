package com.itacademy.homework.homework8;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.itacademy.homework.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;


public class HomeWork8Activity extends AppCompatActivity{
    private Disposable disposable;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework8);
        textView = findViewById(R.id.container_count);
        findViewById(R.id.text_fragment3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disposable = Observable.interval(1, TimeUnit.SECONDS)
                        .filter(new Predicate<Long>() {
                            @Override
                            public boolean test(Long aLong) throws Exception {
                                return aLong%2 == 0;
                            }
                        })
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                return String.valueOf(aLong);
                            }
                        })

                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                           textView.setText(s);
                                       }
                                   });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
