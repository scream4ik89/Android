package com.itacademy.homework.homework6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.itacademy.homework.R;
import com.itacademy.homework.homework6.manager.Manager;
import com.itacademy.homework.homework6.manager.Search.SearchByDate;
import com.itacademy.homework.homework6.model.entity.Beer;
import com.itacademy.homework.homework6.model.entity.Pub;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class HomeWork6Activity extends AppCompatActivity{
    private final String NAMEJSON = "pub.json";
    public static String PARSINGISDONE = "DONE";
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private Manager mManager;
    private LocalBroadcastManager mLocalBroadcastManager;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ((BeerAdapter) mAdapter).setCustomers(mManager.getFinded());
            mAdapter.notifyDataSetChanged();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, new IntentFilter(PARSINGISDONE));

        mManager = Manager.getInstance(LocalBroadcastManager.getInstance(this));
        mManager.setNameOfFile(getFilesDir().toString() + "/" + NAMEJSON);
        mManager.getData();
        mEditText = findViewById(R.id.search);
        mRecyclerView = findViewById(R.id.my_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BeerAdapter(mManager.getFinded());
        mRecyclerView.setAdapter(mAdapter);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              mManager.searchBeerByName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {
        ArrayList<Beer> beers;

        public BeerAdapter(ArrayList<Beer> beers) {
            this.beers = beers;
        }

        @Override
        public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BeerViewHolder(getLayoutInflater().inflate(R.layout.item_pub, parent, false));
        }

        @Override
        public void onBindViewHolder(BeerViewHolder holder, int position) {
            holder.bind(beers.get(position));
        }

        @Override
        public int getItemCount() {
            return beers.size();
        }
        public void setCustomers(ArrayList<Beer> beers){
            this.beers = beers;
        }
    }

    private class BeerViewHolder extends RecyclerView.ViewHolder {

        private TextView id_beer = itemView.findViewById(R.id.id_beer);
        private TextView name_beer = itemView.findViewById(R.id.name_beer);
        private TextView country_beer = itemView.findViewById(R.id.country_beer);
        private TextView year_beer = itemView.findViewById(R.id.year_beer);
        private TextView price_beer = itemView.findViewById(R.id.price_beer);
        private TextView visible_beer = itemView.findViewById(R.id.visible_beer);

        public BeerViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Beer beer) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (beer != null) {
                id_beer.setText("id: " + String.valueOf(beer.getId()));
                name_beer.setText("Name: " + beer.getName());
                country_beer.setText("Country beer: " + beer.getCountry());
                year_beer.setText("Year beer: " + sdf.format(beer.getYear()));
                price_beer.setText("Price beer: " + String.valueOf(beer.getPrice()));
                visible_beer.setText("Visible beer: " + beer.isVisible());
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }
}
