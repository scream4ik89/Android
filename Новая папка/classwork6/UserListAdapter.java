package com.itacademy.myapplication.classwork6;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.itacademy.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> itemList = new ArrayList<>();
    private onUserClickListener listener;

    public void setListener(onUserClickListener listener) {
        this.listener = listener;
    }

    public void setItems(List<User> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged(); // для перересовки изменений данных. иначе новые данные не отобразятся
    }
//создает холдер, который содержит layout - xml, он кешируется, т.е.
    //для разных позиций может использоваться один и тот же холдер
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new Holder(view);
    }
//вызывается для каждого элемента, используется для заполнения данных item - один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder holder1 = (Holder) holder;
        final User user = itemList.get(position);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onClick(user, position);
            }
        });
        Glide.with(holder1.imageView.getContext()).load("https://i.ytimg.com/vi/VN2AhN_Bnvk/maxresdefault.jpg").into(holder1.imageView);
        holder1.nameTextView.setText(user.getName());
        holder1.surnameTextView.setText(user.getSurname());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {


        ImageView imageView;
        TextView nameTextView;
        TextView surnameTextView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter", "create Holder");
            imageView = itemView.findViewById(R.id.image_user);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surnameTextView = itemView.findViewById(R.id.surnameTextView);

        }
    }
    interface onUserClickListener{
        void onClick(User user, int position);
    }
}
