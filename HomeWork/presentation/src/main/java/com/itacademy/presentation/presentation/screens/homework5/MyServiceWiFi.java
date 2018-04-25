package com.itacademy.presentation.presentation.screens.homework5;


import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;


public class MyServiceWiFi extends Service {
    private   MyBinder binder = new MyBinder();
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
        return binder;
    }

    public class MyBinder extends Binder {
        public MyServiceWiFi getService() {
            return MyServiceWiFi.this;
        }
    }
}
