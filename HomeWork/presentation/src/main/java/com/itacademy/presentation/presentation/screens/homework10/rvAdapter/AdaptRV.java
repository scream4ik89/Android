package com.itacademy.presentation.presentation.screens.homework10.rvAdapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itacademy.domain.entity.UserProfileEntity;
import com.itacademy.presentation.databinding.ItemUserProfileBinding;


import java.util.ArrayList;
import java.util.List;

public class AdaptRV extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserProfileEntity> users = new ArrayList<>();

    private Context context;

    private OnClickListener listener;

    public void setUsers(List<UserProfileEntity> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserProfileBinding binding = ItemUserProfileBinding.inflate(inflater, parent, false);
        context = parent.getContext();
        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holderT = (Holder) holder;
        final UserProfileEntity entity = users.get(position);
        holderT.userProfileBinding.setUserProfile(entity);
        holderT.userProfileBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = entity.getObjectId();
                listener.onClick(id);
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ItemUserProfileBinding userProfileBinding;

        Holder(View itemView) {
            super(itemView);
            userProfileBinding = DataBindingUtil.bind(itemView);
        }
    }

    public interface OnClickListener {
        void onClick(String id);
    }

    public void setListener(OnClickListener clickListener) {
        this.listener = clickListener;
    }
}