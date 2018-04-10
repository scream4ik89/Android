package com.itacademy.presentation.base;

//recycle view для mvvm
//данные отсюда должны передоваться в вью модель в активити
public abstract class BaseItemViewModel<Model> {

    public abstract void setItem(Model model, int position);


    //здесь можно использовать use case, но не желательно
    public void init(){

    }

    //аналог метода destroy
    public void release(){

    }
}
