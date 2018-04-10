package com.itacademy.presentation.presentation.screens.mvp;

import android.util.Log;

import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;
import com.itacademy.domain.entity.UserEntity;
import com.itacademy.domain.interactors.GetUserByIdUseCase;
import com.itacademy.domain.interactors.GetUserUseCase;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.presentation.screens.mvvm.list.UserAdapter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SignUserPresenter extends UserPresenter {

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    @Inject
    public GetUserUseCase getUserUseCase;

    public UserAdapter userAdapter = new UserAdapter();

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public SignUserPresenter() {
       // progressVisible.set(true);

        view.showProgress();

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

                        //TODO Implement
                        view.showUser(userEntity);

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
                        //progressVisible.set(false);
                        view.dismissProgress();
                        //TODO Implement
                    }
                });
    }


    @Override
    public void onUserClick() {

    }

    @Override
    public UserAdapter getUserAdapter() {
        return userAdapter;
    }
}
