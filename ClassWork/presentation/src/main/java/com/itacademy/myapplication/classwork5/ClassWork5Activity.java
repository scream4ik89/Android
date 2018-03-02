package com.itacademy.myapplication.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.itacademy.myapplication.R;


public class ClassWork5Activity extends AppCompatActivity {
    private Button button;
    LocalBroadcastManager broadcastManager;
    private static final String ACTION_MY_MESSAGE =
            "com.itacademy.myapplication.classwork5.ACTION_MY_MESSAGE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_MY_MESSAGE);
               // intent.setAction(ACTION_MY_MESSAGE); //или засунуть наше сообщение в конструктор Intent
                // sendBroadcast(intent); не безопасно так делать, т.к. данные идут за пределы приложения
                broadcastManager.sendBroadcast(intent); // ловит сообщения только в пределах приложения

            }
        });

    }

    private BroadcastReceiver myReciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAAA", "Message from MY_ACTION_MESSAGE");
            boolean isWiFi = intent.getBooleanExtra("state", true);
//            boolean isAirplaneModeOn = intent.getBooleanExtra("state",
//                    false);
//            if (isAirplaneModeOn) {
//                Log.e("AAAA", "Message from Activity On mode");
//            } else {
//                Log.e("AAAA", "Message from Activity Off mode");
//            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);
        broadcastManager.registerReceiver(myReciver, intentFilter);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_LINK, "http://film");
        startService(intent2);
        Intent intent3 = new Intent(this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_LINK, "http://film2");
        startService(intent3);
        Intent intent4 = new Intent(this, MyIntentService.class);
        intent4.putExtra(MyIntentService.KEY_LINK, "http://film3");
        startService(intent4);
    }

    @Override
    protected void onStop() {
        super.onStop();
        broadcastManager.unregisterReceiver(myReciver);
        stopService(new Intent(this, MyService.class));
    }
}
