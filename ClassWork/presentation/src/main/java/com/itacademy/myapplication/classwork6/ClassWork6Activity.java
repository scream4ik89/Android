package com.itacademy.myapplication.classwork6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.itacademy.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class ClassWork6Activity extends AppCompatActivity {
    private UserListAdapter userAdapter;
    private RecyclerView recy;
    private String link = "https://st03.kakprosto.ru/tumb/340/images/article/2011/9/10/1_525504a2e3a47525504a2e3a86.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        List<User> userList = new ArrayList<>();
        userList.add(new User(link, "Petr", "Ivanov"));
        userList.add(new User(link, "Max", "Petrov"));
        userList.add(new User(link, "Ivan", "Sidorov"));
        userList.add(new User(link, "Garry", "Kolchin"));
        userList.add(new User(link, "Ken", "Kornev"));
        userList.add(new User(link, "Den", "Jukov"));

        userAdapter = new UserListAdapter();
        userAdapter.setItems(userList);
userAdapter.setListener(new UserListAdapter.onUserClickListener() {
    @Override
    public void onClick(User user, int position) {
        Toast.makeText(ClassWork6Activity.this, user.getName() + position, Toast.LENGTH_SHORT).show();
    }
});
        recy = findViewById(R.id.recycler);

        recy.setAdapter(userAdapter);
        recy.setLayoutManager(new LinearLayoutManager(this));
       // recy.setHasFixedSize(true); // чтоб все элементы были одиннаковыми размерами
    }
}
