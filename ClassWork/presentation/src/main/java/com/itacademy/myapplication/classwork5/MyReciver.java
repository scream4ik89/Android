package com.itacademy.myapplication.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//сюда будут прилетать события на которые мы подписались
public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        intent.getAction();
        Log.e("AAAA", "Message");
    }
}
