package com.itacademy.presentation.injection;



import com.itacademy.presentation.presentation.screens.homework10.UserProfileViewModel;
import com.itacademy.presentation.presentation.screens.homework10_1.UserPFViewModel;
import com.itacademy.presentation.presentation.screens.homework10_2.AddUserViewModel;
import com.itacademy.presentation.presentation.screens.homework9.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(UserViewModel userViewModel);
    void inject(UserProfileViewModel userProfileViewModel);
    void inject(AddUserViewModel addNewUser);

    void inject(UserPFViewModel userPFViewModel);//указываем в каком классе будут произведена сборка
//объекта требующего инжекции
}
