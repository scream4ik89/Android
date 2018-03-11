package com.itacademy.myapplication.classwork9;



import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

public class MyEntitty {
    public ObservableField<String> text = new ObservableField<String>("");
    public ObservableField<String> textButton = new ObservableField<String>("");
    public ObservableBoolean buttonVisible = new ObservableBoolean(true);


    public MyEntitty(String text, String textButton) {
        this.text.set(text);
        this.textButton.set(textButton);
    }


    public void buttonClick(View view){
        if (buttonVisible.get()){
        buttonVisible.set(false);}
        else {buttonVisible.set(true);}
        Log.e("AAA", "Button click");

    }
}
