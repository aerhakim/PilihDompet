package io.github.aerhakim.pilihdompet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.aerhakim.pilihdompet.R;

public class MainActivity extends AppCompatActivity {
    private ImageView btnSettingAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //menghilangkan ActionBar
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        btnSettingAccount = (ImageView) findViewById(R.id.imageProfile);

        btnSettingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AccountSettingActivity.class));
            }
        });
    }
}