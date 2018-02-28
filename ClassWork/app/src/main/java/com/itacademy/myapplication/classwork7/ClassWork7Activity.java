package com.itacademy.myapplication.classwork7;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.itacademy.myapplication.R;


public class ClassWork7Activity extends AppCompatActivity {
    private boolean isOneVisible = true;
    private static String SHARED_PREFS_NAME = "asdas";
    private static String KEY_NAME = "name";
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork7);
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        findViewById(R.id.text_fragmet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
            }
        });
        if (savedInstanceState == null){
            showFragment(OneFragment.getInstance(getSupportFragmentManager(), 1), false);
        }
    }

    private void changeFragment() {
        if (isOneVisible) {
            showFragment(TwoFragment.getInstance(getSupportFragmentManager(), 2), true);
            isOneVisible = false;
        } else {
            showFragment(OneFragment.getInstance(getSupportFragmentManager(), 1), false);
            isOneVisible = true;
        }

    }

    private void showFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());

        if(addToBackStack)fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());

        fragmentTransaction.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        String text = sharedPreferences.getString(KEY_NAME, "");
        Log.e("AAA", "text = " + text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // запись мелких данных в sharedPreferences в виде XML
        sharedPreferences.edit().putString(KEY_NAME, "HELLO").apply();
    }
}
