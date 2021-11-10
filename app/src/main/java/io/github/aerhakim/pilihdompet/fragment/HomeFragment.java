package io.github.aerhakim.pilihdompet.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.activity.MainActivity;
import io.github.aerhakim.pilihdompet.activity.SettingActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_home, container, false);
//        ((MainActivity) getActivity()).FragmentData();
        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView newBlockButton = (ImageView) getActivity().findViewById(
                R.id.imageProfile);
        newBlockButton.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageProfile) {
            Intent intent = new Intent(getActivity(), SettingActivity.class);
            startActivity(intent);
        }
    }
}