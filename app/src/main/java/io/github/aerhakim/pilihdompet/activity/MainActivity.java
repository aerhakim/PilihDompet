package io.github.aerhakim.pilihdompet.activity;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
import io.github.aerhakim.pilihdompet.fragment.EwalletFragment;
import io.github.aerhakim.pilihdompet.fragment.HomeFragment;
import io.github.aerhakim.pilihdompet.fragment.PromoFragment;
import io.github.aerhakim.pilihdompet.fragment.WishlistFragment;


public class MainActivity extends AppCompatActivity {
    //deklrasasi Firebase
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    FirebaseUser user;
    String userId;
    //deklarasi button/item yang ingin diganti

    ImageView profileImage;
    TextView tvNama;
    private BottomNavigationView navigation;
    private ViewPager viewPager;
    int pager_number = 4;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(android.R.id.content);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(pager_number);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_category:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_promo:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_wishlist:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        });

    }

//    public void FragmentData() {
//        //deklarasi Firebase
//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();
//        profileImage = findViewById(R.id.imageProfile);
//
//        tvNama = findViewById(R.id.nama);
//
//        //firebase buat ambil foto
//        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
//        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load(uri).into(profileImage);
//            }
//        });
//
//        //deklarasi Firebase
//        userId = fAuth.getCurrentUser().getUid();
//        user = fAuth.getCurrentUser();
//
//        //deklarasi fire base untuk mengganti data statis ke dinamis dr firebase
//        DocumentReference documentReference = fStore.collection("users").document(userId);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                if(documentSnapshot.exists()){
//                    tvNama.setText(documentSnapshot.getString("fName"));
//
//                }else {
//                    Log.d("tag", "onEvent: Document do not exists");
//                }
//            }
//        });
//    }

    public class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new EwalletFragment();
                case 2:
                    return new PromoFragment();
                case 3:
                    return new WishlistFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return pager_number;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}
