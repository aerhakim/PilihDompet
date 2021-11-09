package io.github.aerhakim.pilihdompet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.adapter.HerosAdapter;
import io.github.aerhakim.pilihdompet.model.GetHeros;
import io.github.aerhakim.pilihdompet.model.Heros;
import io.github.aerhakim.pilihdompet.rest.ApiClient;
import io.github.aerhakim.pilihdompet.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ObatActivity extends AppCompatActivity {

//    ApiInterface mApiInterface;
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//    public static ObatActivity ma;
//    private FloatingActionButton fabAdd;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_obat);
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_heros);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//        ma=this;
//        refresh();
//
//        fabAdd = findViewById(R.id.fab_add);
//        fabAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ObatActivity.this, InsertActivity.class));
//            }
//        });
//    }
//
//    public void refresh() {
//        Call<GetHeros> HerosCall = mApiInterface.getHeros();
//        HerosCall.enqueue(new Callback<GetHeros>() {
//            @Override
//            public void onResponse(Call<GetHeros> call, Response<GetHeros>
//                    response) {
//                List<Heros> HerosList = response.body().getListDataHeros();
//                Log.d("Retrofit Get", "Jumlah data Heros: " +
//                        String.valueOf(HerosList.size()));
//                mAdapter = new HerosAdapter(HerosList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetHeros> call, Throwable t) {
//                Log.e("Retrofit Get", t.toString());
//            }
//        });
//    }
}