package com.itacademy.presentation.presentation.screens.homework1;


import android.databinding.ObservableField;

import com.itacademy.presentation.base.BaseViewModel;

public class HW1ViewModel extends BaseViewModel{
    @Override
    public void createInject() {

    }
    public ObservableField<String> textView1 = new ObservableField<>("Hello");
    public ObservableField<String> textView2 = new ObservableField<>("world!");

    public void switchText(){
        String textTMP = textView1.get();
        textView1.set(textView2.get());
        textView2.set(textTMP);
    }
}
