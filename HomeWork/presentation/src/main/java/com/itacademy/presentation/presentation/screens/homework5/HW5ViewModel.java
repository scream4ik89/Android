package com.itacademy.presentation.presentation.screens.homework5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.ObservableField;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;

import com.itacademy.presentation.base.BaseViewModel;

import static android.content.Context.BIND_AUTO_CREATE;

public class HW5ViewModel extends BaseViewModel {

    private Context context;
    public final ObservableField<String> connectWi_Fi = new ObservableField<>();
    private BroadcastReceiver broadcastReceiver;
    private ServiceConnection sConn;
    private MyServiceWiFi myService;
    private Intent intent;

    public void setContext(Context context) {
        this.context = context;

    }

    public void switchOnWiFi() {
        myService.changeWiFiState();
    }

    public void switchOffWiFi() {
        myService.changeWiFiState();
    }

    @Override
    public void createInject() {

    }

    @Override
    public void onStart() {
        intent = new Intent(context, MyServiceWiFi.class);
        sConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService = ((MyServiceWiFi.MyBinder) service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        };
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getExtras() != null) {
                    NetworkInfo ni = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
                    if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED) {
                        connectWi_Fi.set("Network " + ni.getTypeName() + " connected");

                    } else if (ni != null && ni.getState() == NetworkInfo.State.DISCONNECTED) {
                        connectWi_Fi.set("There's no network connectivity");
                    }
                }
            }
        };
        context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        context.bindService(intent, sConn, BIND_AUTO_CREATE);
    }


    @Override
    public void onStop() {
        super.onStop();
        context.unregisterReceiver(broadcastReceiver);
        context.unbindService(sConn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
    }
}

