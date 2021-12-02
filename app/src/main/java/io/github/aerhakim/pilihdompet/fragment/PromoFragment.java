package io.github.aerhakim.pilihdompet.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.List;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.rest.Config;
import io.github.aerhakim.pilihdompet.adapter.PromoAdapter;
import io.github.aerhakim.pilihdompet.model.GetPromo;
import io.github.aerhakim.pilihdompet.model.Promo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromoFragment extends Fragment {
    RecyclerView recyclerView;
    List<Promo> promoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //retrofit

        Call<GetPromo> call= Config.getInstance().getApi().promo();

        call.enqueue(new Callback<GetPromo>() {
            @Override
            public void onResponse(Call<GetPromo> call, Response<GetPromo> response) {

                if(response.isSuccessful()){

                    promoList =response.body().getPromoList();
                    recyclerView.setAdapter(new PromoAdapter(getActivity(), promoList));

                }
                else{
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetPromo> call, Throwable t) {
                //onFailure Retrofit di PromoFragment Toast Nya tidak diaktifkan,
                // karena di Mainactivity sudah ada toast yg sama di E-Wallet Fragment
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}