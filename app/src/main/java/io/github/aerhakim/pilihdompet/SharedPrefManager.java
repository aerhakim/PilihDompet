package io.github.aerhakim.pilihdompet;

import android.content.Context;
import android.content.SharedPreferences;

import io.github.aerhakim.pilihdompet.model.Ewallet;


public class SharedPrefManager {

    private static String SHARED_PREF_NAME="pilihdompet";
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;


    public Ewallet getEwallet(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Ewallet(sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("nama",null),
                sharedPreferences.getString("size",null),
                sharedPreferences.getString("gambar",null),
                sharedPreferences.getString("rating",null),
                sharedPreferences.getString("detail",null),
                sharedPreferences.getString("feetrx",null));
    }

}
