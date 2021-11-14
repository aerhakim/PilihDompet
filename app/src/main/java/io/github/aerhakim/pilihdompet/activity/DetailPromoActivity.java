package io.github.aerhakim.pilihdompet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import io.github.aerhakim.pilihdompet.R;


//
//public class DetailPromoActivity extends AppCompatActivity {
//    TextView promoJudul,promoDeskripsi, promoUser, promoSNK, promoEwallet;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//        // Identifikasi Komponen Form
//        promoJudul = (TextView) findViewById(R.id.promoJudul);
//        promoSNK = (TextView) findViewById(R.id.promoSNK);
//        promoUser = (TextView) findViewById(R.id.promoUser);
//        promoEwallet = (TextView) findViewById(R.id.promoSNK);
//        promoDeskripsi = (TextView) findViewById(R.id.promoPeriode);
//
//
//        // Identifikasi intent ke Komponen Form
//        Intent mIntent = getIntent();
//        promoJudul.setText(mIntent.getStringExtra("judul"));
//        promoUser.setText(mIntent.getStringExtra("user"));
//        promoEwallet.setText(mIntent.getStringExtra("ewallet"));
//        promoDeskripsi.setText(mIntent.getStringExtra("deskripsi"));
//        promoSNK.setText(mIntent.getStringExtra("snk"));
//
//
//
//    }
//}