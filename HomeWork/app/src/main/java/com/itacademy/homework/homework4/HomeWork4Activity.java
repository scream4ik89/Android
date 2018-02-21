package com.itacademy.homework.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.itacademy.homework.R;


public class HomeWork4Activity extends AppCompatActivity {
    private Button button, button2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);
        button = findViewById(R.id.dz4_1);
        button2 = findViewById(R.id.dz4_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWork4Activity.this, HomeWork4_1Activity.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeWork4Activity.this,HomeWork4_2Activity.class));
            }
        });
    }
}
