package com.itacademy.presentation.presentation.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.itacademy.presentation.R;
import com.squareup.picasso.Picasso;

public class AdaptersDataBinding {

    @BindingAdapter(value = {"bind:error", "android:src"}, requireAll = false)
    public static void setImageUrl(@NonNull ImageView imageView, @NonNull String url, Drawable error) {
        Context context = imageView.getContext();
            Picasso.with(context).load(url).error(error).transform(new CircleTransformation()).into(imageView);

    }
    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner spinner, Boolean gender, final InverseBindingListener newTextAttrChanged) {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newTextAttrChanged.onChange();//оповешает модель по обратной связи что произошли изменения
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        if (gender) {
            int pos = ((ArrayAdapter<String>) spinner.getAdapter()).getPosition("Male");
            spinner.setSelection(pos, true);
        } else {
            int pos = ((ArrayAdapter<String>) spinner.getAdapter()).getPosition("Female");
            spinner.setSelection(pos, true);
        }
    }

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static Boolean captureSelectedValue(AppCompatSpinner pAppCompatSpinner) {
        if (((String) pAppCompatSpinner.getSelectedItem()).equals("Male")) {
            return true;
        } else {
            return false;
        }
        //получаем выбраную позицию и возврашаем в во вью
        //можем возвратить так-как мы поставили равно во вью(это значит со вью приходит какое-то
        //значение(с прослушиваемого поля) и мы можем передать новое значение в прослушиваемое поле
    }

    /**
     * Разъяснение адаптеров
     * bind:adapter - кастомный атрибут, при встрече этого абтрибута зайдёт в этот статический адаптер
     *
     * @param spinner - то что приходит со вью(само вью) для чего нужно адаптировать данные;
     * @param dapter  - приходящие данные от view model эти данные необходимо адаптировать;
     *                для спинеров необходимы начальные данные(до встричи атрибута bind:adapter)
     *                иначе ошибка
     * Адаптер служит для того что бы не писать логику преобразования во ViewModel(что бы ViewModel
     *                не знала о View) какие данные пришли от модели, те и адаптируем к View(отабражению)
     */
    @BindingAdapter("bind:adapter")
    public static void setAdapterSpinner(AppCompatSpinner spinner, ObservableField<String> dapter) {
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(spinner.getContext(), R.array.sexSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

}
