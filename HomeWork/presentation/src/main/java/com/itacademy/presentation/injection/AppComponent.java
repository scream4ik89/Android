package com.itacademy.presentation.injection;



import com.itacademy.presentation.presentation.screens.homework9.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(UserViewModel userViewModel);
}
