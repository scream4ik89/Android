package com.itacademy.homework.homework3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.itacademy.homework.BuildConfig;
import com.itacademy.homework.R;

public class HomeWork3Activity extends AppCompatActivity{
    private TextView textViewd;
    private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework2);
        textViewd = findViewById(R.id.textViewDz3);
        textViewd.setText(BuildConfig.API_ENDPOINT);
        editText = findViewById(R.id.editText);
    }
}
