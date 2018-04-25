package com.itacademy.presentation.presentation.screens.homework10_2;

import android.content.Context;
import android.databinding.InverseMethod;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.Toast;

import com.itacademy.data.entity.Erorr;
import com.itacademy.data.entity.ErrorType;
import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.domain.interactors.AddNewUserPFUseCase;
import com.itacademy.presentation.app.App;
import com.itacademy.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class AddUserViewModel extends BaseViewModel {

    public final ObservableField<String> fullName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();

    @Inject
    public AddNewUserPFUseCase addUser;

    @Inject
    public Context context;

    public AddUserViewModel() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void createInject() {

    }

    public void addNewUser() {
        addUser.addNewUser(new UserProfileEntity(fullName.get(), "", age.get(), false, ""))
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "User saved",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                        if (e instanceof Erorr){
                            Erorr myError = (Erorr) e;
                            if (myError.getMyError() == ErrorType.NO_INTERNET){
                                Toast.makeText(context, "Упс, нет интернета",
                                        Toast.LENGTH_LONG).show();
                                //сообщение об ощибке
                            } else if (myError.getMyError() == ErrorType.SERVER_NOT_AVAILABLE){
                                Toast.makeText(context, "Сервер не доступен",
                                        Toast.LENGTH_LONG).show();
                                //сообщение об ощибке
                            }
                        }
                        else {

                        }
                    }
                });

    }

    @InverseMethod("convertFromString")
    public String convertFromInt(int age) {
        return String.valueOf(age);
    }

    public int convertFromString(String age) {
        if (age.length() == 0)
            return 0;
        return Integer.valueOf(age);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
    }
}