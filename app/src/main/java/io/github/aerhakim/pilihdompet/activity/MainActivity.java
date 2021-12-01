package io.github.aerhakim.pilihdompet.activity;


import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.Rest.Config;
import io.github.aerhakim.pilihdompet.fragment.EwalletFragment;
import io.github.aerhakim.pilihdompet.fragment.HomeFragment;
import io.github.aerhakim.pilihdompet.fragment.PromoFragment;
import io.github.aerhakim.pilihdompet.fragment.WishlistFragment;
import io.github.aerhakim.pilihdompet.model.GetToken;
import io.github.aerhakim.pilihdompet.activity.CekKoneksi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "PushNotification";
    private static final String CHANNEL_ID = "101";
    public BottomNavigationView navigation;
    public ViewPager viewPager;
    MenuItem prevMenuItem;
    int pager_number = 4;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(android.R.id.content);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(pager_number);
        createNotificationChannel();
        getToken();
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
//                    Jika mau pindah dari fragment ke activity
//                            Intent i = new Intent(this, SettingActivity.class);
//                            startActivity(i);
                    return true;
            }
            return false;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        cekKoneksi();
    }

    public void cekKoneksi () {
        if(isNetworkAvailable()) {
            //Keknya ga ush di isi, dibiarin aja
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Tidak ada Koneksi Internet!");
            builder.setMessage("Silahkan Periksa Koneksi Internet Anda dan Coba Kembali!");

            builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (Build.VERSION.SDK_INT >= 11) {
//                        recreate();
//                    }else{
                    Intent j = getIntent();
                    finish();
                    startActivity(j);
//                    }
                }
            });

            builder.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });

            AlertDialog dialog  = builder.create();
            dialog.show();
            Toast.makeText(this,"Koneksi Internet Tidak Ada", Toast.LENGTH_SHORT).show();

        }
    }


    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //If task is failed then
                if (!task.isSuccessful()) {
                    Log.d(TAG, "onComplete: Failed to get the Token");
                }


                //Token
                String token = task.getResult();
                Log.d(TAG, "onComplete: " + token);

                String tokenfcm = token;
                Call<GetToken> call= Config
                        .getInstance()
                        .getApi()
                        .register(tokenfcm);
                call.enqueue(new Callback<GetToken>() {
                                 @Override
                                 public void onResponse(Call<GetToken> call, Response<GetToken> response) {
                                    //ga tau mau diisi apa
                                 }

                                 @Override
                                 public void onFailure(Call<GetToken> call, Throwable t) {

                                     Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                                 }
                             });
            }
        });
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "firebaseNotifChannel";
            String description = "Receve Firebase notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
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
