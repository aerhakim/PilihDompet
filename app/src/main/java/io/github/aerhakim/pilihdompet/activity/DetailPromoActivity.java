package io.github.aerhakim.pilihdompet.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import io.github.aerhakim.pilihdompet.R;



public class DetailPromoActivity extends BottomSheetDialogFragment {
    TextView promoJudul,promoDeskripsi, promoUser, promoSNK, promoEwallet, promoTglend;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_detail_promo, container, false);
    }
}