package com.itacademy.homework.homework1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.itacademy.homework.R;


public class HomeWork1Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView textview;
    private TextView textview2;
    private Button button;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switchText();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);
        textview = findViewById(R.id.textview);
        textview2 = findViewById(R.id.textview2);
        textview.setOnClickListener(this);
        textview2.setOnClickListener(listener);
        button = findViewById(R.id.button_switch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchText();
            }
        });
    }
    private void switchText(){
        String textTMP = textview.getText().toString();
        textview.setText(textview2.getText());
        textview2.setText(textTMP);
    }
    @Override
    public void onClick(View v) {
    switchText();
    }
}
