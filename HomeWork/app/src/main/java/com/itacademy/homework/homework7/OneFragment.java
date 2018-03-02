package com.itacademy.homework.homework7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.itacademy.homework.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


public class OneFragment extends Fragment {
    private PublishContract publishContract;
    private TextView textView;
    private Disposable disposable;

    public static OneFragment getInstance() {
        return new OneFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_fragmet2);

        //здесь происходит инициализация всех кнопок, и прочей лабуды в XML
    }

    @Override
    public void onResume() { // подписываемся на изменения
        super.onResume();
        disposable = publishContract.getObservable()
                .doOnNext(new Consumer<Integer>() { //можно делать промежуточные действия
                    @Override
                    public void accept(Integer integer) throws Exception {
                    }
                })
                .map(new Function<Integer, String>() { //превращает один тип данных в другой
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                    }
                })
                .subscribe(new Consumer<String>() {
                               @Override
                               //сюда приходят данные
                               public void accept(String text) throws Exception {
                                   textView.setText(text);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });

    }

    @Override
    public void onPause() {
        super.onPause();
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity(); //получаем ссылку на активити
        if (activity != null) {
            publishContract = (PublishContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }
}
