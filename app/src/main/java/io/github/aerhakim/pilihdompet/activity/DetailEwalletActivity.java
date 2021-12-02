package io.github.aerhakim.pilihdompet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.rest.Api;
import io.github.aerhakim.pilihdompet.rest.ApiDetail;
import io.github.aerhakim.pilihdompet.rest.Config;

public class DetailEwalletActivity extends AppCompatActivity {
    TextView appName,appFee, appSize, appDetail;
    ImageView appGambar;
    Api mApiInterface;
    AppCompatRatingBar appRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Identifikasi Komponen Form
        appSize = (TextView) findViewById(R.id.etSize);
        appGambar = (ImageView) findViewById(R.id.ivGambar);
        appName = (TextView) findViewById(R.id.tvJudul);
        appFee = (TextView) findViewById(R.id.etFeetrx);
        appDetail = (TextView) findViewById(R.id.etDetail);
        appRating = (AppCompatRatingBar) findViewById(R.id.etRating);

        // Identifikasi intent ke Komponen Form
        Intent mIntent = getIntent();
        appSize.setText(mIntent.getStringExtra("size"));
        appName.setText(mIntent.getStringExtra("nama"));
        appFee.setText(mIntent.getStringExtra("feetrx"));
        appDetail.setText(mIntent.getStringExtra("detail"));
        appRating.setRating(mIntent.getFloatExtra("rating", 0.0f));

        // Masukan Gambar Ke Image View Gunakan Glide
        Glide.with(DetailEwalletActivity.this)
                .load(Config.IMAGES_URL + mIntent.getStringExtra("gambar"))
                .apply(new RequestOptions().override(350, 550))
                .into(appGambar);

        // Definisi API
        mApiInterface = ApiDetail.getClient().create(Api.class);
    }
}