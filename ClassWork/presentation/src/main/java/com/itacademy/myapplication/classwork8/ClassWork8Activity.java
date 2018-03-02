package com.itacademy.myapplication.classwork8;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.itacademy.myapplication.R;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


public class ClassWork8Activity extends AppCompatActivity implements PublishContract {

    private PublishSubject<Integer> publishSubject = PublishSubject.create();
    private int count = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork8);
        findViewById(R.id.text_fragmet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishSubject.onNext(count);
                count++;
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, OneFragment.getInstance());
        transaction.commit();
    }

    @Override
    public Observable<Integer> getObservable() {
        return publishSubject;
    }
}
