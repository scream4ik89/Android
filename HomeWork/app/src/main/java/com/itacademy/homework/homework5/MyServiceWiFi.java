package com.itacademy.homework.homework5;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyServiceWiFi extends Service {
    private   MyBinder binder;
    private   WifiManager manager;

    public MyServiceWiFi() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    public void changeWiFiState() {
        manager.setWifiEnabled(!manager.isWifiEnabled());
    }

    @Override
    public IBinder onBind(Intent intent) {
        binder = new MyBinder();
        return binder;
    }

    public class MyBinder extends Binder {
        public MyServiceWiFi getService() {
            return MyServiceWiFi.this;
        }
    }
}
