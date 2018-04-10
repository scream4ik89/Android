package com.itacademy.presentation.presentation.screens.mvvm;

import android.app.Activity;
import android.content.Intent;

import com.itacademy.presentation.base.Router;


public class UserRouter extends Router {

    public UserRouter(Activity activity) {
        super(activity);
    }

    public void navigateToUser(String id){

        Intent intent = new Intent(getActivity(), UserActivity.class);
        intent.putExtra("key", id);
        getActivity().startActivity(intent);

        //альтернативный вариант передачи активити
        UserActivity.show(getActivity(), id);
    }


}
