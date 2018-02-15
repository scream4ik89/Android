package com.itacademy.myapplication.ClassWork2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.itacademy.myapplication.R;

public class ClassWork2Activity extends AppCompatActivity{
    private static final String TAG = ClassWork2Activity.class.getSimpleName();
    private Button button1;
    private Button button2;
    public static final String KEY_TEXT = "KEY_TEXT";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);
        String text = getIntent().getStringExtra(KEY_TEXT);

        if (text.contains("Helllo")){
            Log.e("AAA", "contain");
        }
        else {
            Log.e("BBB", "not contain");
        }

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }

        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();}

        });
    }
}