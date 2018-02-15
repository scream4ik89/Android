package com.itacademy.homework.homework_switch;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.itacademy.homework.R;
import com.itacademy.homework.homework1.HomeWork1Activity;
import com.itacademy.homework.homework2.HomeWork2Activity;
import com.itacademy.homework.homework3.HomeWork3Activity;

public class SwitcherActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        button = findViewById(R.id.dz1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork1Activity.class));
            }
        });

        button2 = findViewById(R.id.dz2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork2Activity.class));
            }
        });

        button3 = findViewById(R.id.dz3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork3Activity.class));
            }
        });
    }

}
