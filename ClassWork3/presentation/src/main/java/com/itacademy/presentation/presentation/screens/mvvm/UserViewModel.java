package com.itacademy.presentation.presentation.screens.mvvm;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;
import com.itacademy.domain.entity.UserEntity;
import com.itacademy.domain.interactors.GetUserByIdUseCase;
import com.itacademy.domain.interactors.GetUserUseCase;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.base.BaseAdapter;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.presentation.screens.mvvm.list.UserAdapter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class UserViewModel extends BaseViewModel<UserRouter> {

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    @Inject
    public GetUserUseCase getUserUseCase;

    public UserAdapter userAdapter = new UserAdapter();

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

        if (router != null) router.navigateToUser("1");

        //подписываемся на клик

        userAdapter.observeClick()
                .subscribe(new Observer<BaseAdapter.ItemEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(BaseAdapter.ItemEntity itemEntity) {


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        progressVisible.set(true);
        getUserByIdUseCase
                .get("id")
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
                        if (e instanceof Erorr){
                            Erorr myError = (Erorr) e;
                            if (myError.getMyError() == ErrorType.NO_INTERNET){
                                //сообщение об ощибке
                            } else if (myError.getMyError() == ErrorType.SERVER_NOT_AVAILABLE){
                                //сообщение об ощибке
                            }
                        }
                        else {

                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "onComplete");
                        progressVisible.set(false);
                    }
                });
    }



}
