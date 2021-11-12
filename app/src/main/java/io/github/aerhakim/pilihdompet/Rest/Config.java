package io.github.aerhakim.pilihdompet.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {


    private static String BASE_URL="https://testfintech.000webhostapp.com/";
    public static final String IMAGES_URL = "https://testfintech.000webhostapp.com/gambar/";
    private static Config config;
    private static Retrofit retrofit;

    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    public Config() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();


    }


    public static synchronized Config getInstance(){

        if(config ==null){
            config =new Config();
        }
        return config;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
