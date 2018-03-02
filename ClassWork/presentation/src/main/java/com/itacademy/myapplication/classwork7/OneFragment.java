package com.itacademy.myapplication.classwork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itacademy.myapplication.R;


public class OneFragment extends Fragment {
    private static final String KEY_VALUE = "KEY_VALUE";

    public static OneFragment getInstance(FragmentManager fragmentManager, int value){
        //передача аргумента в фрагмент
        OneFragment fragment = (OneFragment) fragmentManager.findFragmentByTag(OneFragment.class.getSimpleName());
        if (fragment == null){
            fragment = new OneFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE, value);
        fragment.setArguments(bundle);
        return new OneFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            int value = bundle.getInt(KEY_VALUE);
        }
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
        //здесь происходит инициализация всех кнопок, и прочей лабуды в XML
    }

}
