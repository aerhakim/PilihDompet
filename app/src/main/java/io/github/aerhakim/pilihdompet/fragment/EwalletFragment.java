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
import io.github.aerhakim.pilihdompet.adapter.WalletAdapter;
import io.github.aerhakim.pilihdompet.model.GetEwallet;
import io.github.aerhakim.pilihdompet.model.Ewallet;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EwalletFragment extends Fragment {



    RecyclerView recyclerView;
    List<Ewallet> ewalletList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ewallet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //retrofit

        Call<GetEwallet> call= Config.getInstance().getApi().fetchAllUsers();

        call.enqueue(new Callback<GetEwallet>() {
            @Override
            public void onResponse(Call<GetEwallet> call, Response<GetEwallet> response) {

                if(response.isSuccessful()){

                    ewalletList =response.body().getEwalletList();
                    recyclerView.setAdapter(new WalletAdapter(getActivity(), ewalletList));

                }
                else{
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetEwallet> call, Throwable t) {
                Toast.makeText(getActivity(),"Silahkan Periksa Koneksi Internet Anda", Toast.LENGTH_SHORT).show();
            }
        });


    }
}