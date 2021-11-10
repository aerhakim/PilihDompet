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
import io.github.aerhakim.pilihdompet.RetrofitClient;
import io.github.aerhakim.pilihdompet.UserAdapter;
import io.github.aerhakim.pilihdompet.model.FetchUserResponse;
import io.github.aerhakim.pilihdompet.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EwalletFragment extends Fragment {



    RecyclerView recyclerView;
    List<User> userList;

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

        Call<FetchUserResponse> call= RetrofitClient.getInstance().getApi().fetchAllUsers();

        call.enqueue(new Callback<FetchUserResponse>() {
            @Override
            public void onResponse(Call<FetchUserResponse> call, Response<FetchUserResponse> response) {

                if(response.isSuccessful()){

                    userList=response.body().getUserList();
                    recyclerView.setAdapter(new UserAdapter(getActivity(),userList));

                }
                else{
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FetchUserResponse> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}