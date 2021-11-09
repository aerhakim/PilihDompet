package io.github.aerhakim.pilihdompet.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import javax.annotation.Nullable;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.activity.MainActivity;
import io.github.aerhakim.pilihdompet.activity.SettingActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {
    //deklrasasi Firebase
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    FirebaseUser user;
    String userId;
    //deklarasi button/item yang ingin diganti
    ImageView btnSettingAccount;
    ImageView profileImage;
    TextView tvNama;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_home, container, false);
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