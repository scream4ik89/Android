package com.itacademy.presentation.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.itacademy.presentation.BR;


public abstract class BaseItemViewHolder<Model, ViewModel extends BaseItemViewModel,
        Binding extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private Binding binding;
    private ViewModel viewModel;

    public BaseItemViewHolder(Binding binding, ViewModel viewModel) {

        super(binding.getRoot()); //базовая view

        this.binding = binding;
        this.viewModel =viewModel;
        viewModel.init();
        initViewModel();
    }

    protected void initViewModel(){
        binding.setVariable(BR.viewModel, viewModel); //имя нашей xml
    }

    //метод для заполнения данных. аналог Holder в стандартном recycle view
    public void bindTo(Model model, int position){
        viewModel.setItem(model, position);
        binding.executePendingBindings(); //принудительная проверка на заполнение данных
    }

    public void release(){
        this.viewModel.release();
    }

}
