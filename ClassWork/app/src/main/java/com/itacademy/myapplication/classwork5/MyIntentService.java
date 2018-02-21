package com.itacademy.myapplication.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyIntentService extends IntentService {

public static final String KEY_LINK = "KEY_LINK";
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("aaaaa", "IntentService onDestroy");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String link = intent.getStringExtra(KEY_LINK);

        Log.e("aaaaa", "IntentService  " + link);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}
