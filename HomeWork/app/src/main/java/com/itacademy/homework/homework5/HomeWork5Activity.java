package com.itacademy.homework.homework5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.itacademy.homework.R;



public class HomeWork5Activity extends AppCompatActivity {
    private Button wi_fiOn, wi_fiOff;
    private WifiManager manager;
    private ServiceConnection connection;
    private boolean bound = false;
    private MyServiceWiFi.MyBinder binder;
    BroadcastReceiver myReciver;
    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        wi_fiOn = findViewById(R.id.WiFiOn);
        wi_fiOff = findViewById(R.id.WiFiOn);
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        myReciver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                statusWiFi();
            }
        };
        registerReceiver(myReciver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (MyServiceWiFi.MyBinder) service;
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
        bindService(new Intent(this, MyServiceWiFi.class), connection, BIND_AUTO_CREATE);
        wi_fiOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binder.getService().changeWiFiState();
            }
        });
    }

    public void statusWiFi(){
        if(manager.isWifiEnabled()){
            Toast.makeText(getApplicationContext(), "Wi-Fi On", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Wi-Fi Off", Toast.LENGTH_SHORT).show();
        }
    }

}
