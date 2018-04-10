package com.itacademy.presentation.presentation.screens.homework9;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.itacademy.domain.entity.UserEntity;
import com.itacademy.domain.interactors.GetUserByIdUseCase;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class UserViewModel extends BaseViewModel {

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    public ObservableField<String> userName = new ObservableField<String>("");
    public ObservableField<String> profileUrl = new ObservableField<String>("");
    public ObservableField<String> age = new ObservableField<String>("");
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public UserViewModel() {
        super();
        progressVisible.set(true);
        getUserByIdUseCase
                .get("1")
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "onSubscribe");
                        compositeDisposable.add(d); //добовляем в композит диспоз наш диспоз
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("AAA", "onNext");
                        userName.set(userEntity.getUserName());
                        profileUrl.set(String.valueOf(userEntity.getProfileUrl()));
                        age.set(String.valueOf(userEntity.getAge()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "onComplete");
                        progressVisible.set(false);
                    }
                });
    }



}
