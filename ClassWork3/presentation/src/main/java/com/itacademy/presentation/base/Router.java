package com.itacademy.presentation.base;

import android.app.Activity;

public abstract class Router {

    protected Activity activity;

    public Router(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void back(){

        getActivity().onBackPressed();
    }
}
