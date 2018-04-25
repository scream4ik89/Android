package com.itacademy.presentation.presentation.screens.homework9;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.itacademy.data.repository.UserRepositoryImpl;
import com.itacademy.domain.entity.User;
import com.itacademy.domain.interactors.GetUserUseCase;
import com.itacademy.presentation.base.BaseViewModel;
import com.itacademy.presentation.executor.UIThread;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class UserViewModel extends BaseViewModel {

    //таким образом всё общение с data происходит через useCase(где описывается логика поведения
    //данных. Сколько нужно операций, стольоко необходимо и создавать useCase
    private GetUserUseCase getUserUseCase = new GetUserUseCase(new UIThread(), new UserRepositoryImpl());
    //поля обёртки, с ними изменения будут подтягвать автомитически
    public final ObservableField<String> name = new ObservableField<>("");
    public final ObservableField<String> surName = new ObservableField<>("");
    public final ObservableField<String> url = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean loadUser = new ObservableBoolean(false);
    public final ObservableBoolean isSex = new ObservableBoolean(false);

    public UserViewModel() {
        //как правило подписки делают в конструкторе, что бы не тратить ресурсы, пересоздавая каждый
        //раз при возвращении в активити
        getUserUseCase.getUser().delay(3, TimeUnit.SECONDS)
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        setUser(user);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        loadUser.set(true);
                    }
                });
    }

    @Override
    public void createInject() {

    }


    public void setUser(User newUser) {
        this.name.set(newUser.getName());
        this.surName.set(newUser.getSurName());
        this.url.set(newUser.getUrl());
        this.age.set(newUser.getAge());
        this.isSex.set(newUser.getSex());
    }


    public User getUser() {

        return new User(this.name.get(), this.surName.get(), this.url.get(), this.age.get(), this.isSex.get());
    }

}
