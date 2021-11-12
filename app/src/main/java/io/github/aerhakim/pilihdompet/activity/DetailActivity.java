package io.github.aerhakim.pilihdompet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.Rest.Api;
import io.github.aerhakim.pilihdompet.Rest.ApiDetail;
import io.github.aerhakim.pilihdompet.Rest.Config;

public class DetailActivity extends AppCompatActivity {
    TextView appName,appFee, appSize, appRating, appDetail;
    ImageView appGambar;
    Api mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Identifikasi Komponen Form
        appSize = (TextView) findViewById(R.id.etSize);
        appGambar = (ImageView) findViewById(R.id.img_item_photo);
        appName = (TextView) findViewById(R.id.etNama);
        appFee = (TextView) findViewById(R.id.etFeetrx);
        appDetail = (TextView) findViewById(R.id.etDetail);
        appRating = (TextView) findViewById(R.id.etRating);

        // Identifikasi intent ke Komponen Form
        Intent mIntent = getIntent();
        appSize.setText(mIntent.getStringExtra("size"));
        appName.setText(mIntent.getStringExtra("nama"));
        appFee.setText(mIntent.getStringExtra("feetrx"));
        appDetail.setText(mIntent.getStringExtra("detail"));
        appRating.setText(mIntent.getStringExtra("rating"));

        // Masukan Gambar Ke Image View Gunakan Glide
        Glide.with(DetailActivity.this)
                .load(Config.IMAGES_URL + mIntent.getStringExtra("gambar"))
                .apply(new RequestOptions().override(350, 550))
                .into(appGambar);

        // Definisi API
        mApiInterface = ApiDetail.getClient().create(Api.class);
    }
}