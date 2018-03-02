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
import com.itacademy.homework.homework4.HomeWork4Activity;
import com.itacademy.homework.homework5.HomeWork5Activity;
import com.itacademy.homework.homework7.HomeWork7Activity;

public class SwitcherActivity extends AppCompatActivity {
    private Button button, button2, button3, button4, button5, button7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        button = findViewById(R.id.dz1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork1Activity.class));
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
            }
        });
        button2 = findViewById(R.id.dz2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork2Activity.class));
                overridePendingTransition(R.anim.left_out, R.anim.alpha);
            }
        });

        button3 = findViewById(R.id.dz3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork3Activity.class));
                overridePendingTransition(R.anim.top_out, R.anim.alpha);
            }
        });
        button4 = findViewById(R.id.dz4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork4Activity.class));
                overridePendingTransition(R.anim.bottom_in, R.anim.alpha);
            }
        });
        button5 = findViewById(R.id.dz5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork5Activity.class));
                overridePendingTransition(R.anim.bottom_in, R.anim.alpha);
            }
        });
        button7 = findViewById(R.id.dz7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwitcherActivity.this, HomeWork7Activity.class));
                overridePendingTransition(R.anim.bottom_in, R.anim.alpha);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.top_out, R.anim.alpha);
    }
}
