package io.github.aerhakim.pilihdompet;

import android.content.Context;
import android.content.SharedPreferences;

import io.github.aerhakim.pilihdompet.model.User;


public class SharedPrefManager {

    private static String SHARED_PREF_NAME="thecodingshef";
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;


    public SharedPrefManager(Context context) {
        this.context = context;
    }



   public boolean isLoggedIn(){
       sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
       return sharedPreferences.getBoolean("logged",false);
    }


    public User getUser(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("nama",null),
                sharedPreferences.getString("size",null),
                sharedPreferences.getString("gambar",null),
                sharedPreferences.getString("rating",null),
                sharedPreferences.getString("detail",null),
                sharedPreferences.getString("feetrx",null));
    }


   public void logout(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

        }
}
