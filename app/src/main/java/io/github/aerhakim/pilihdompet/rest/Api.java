package io.github.aerhakim.pilihdompet.rest;



import io.github.aerhakim.pilihdompet.model.GetEwallet;
import io.github.aerhakim.pilihdompet.model.GetPromo;
import io.github.aerhakim.pilihdompet.model.GetToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("ewallet.php")
    Call<GetEwallet> fetchAllUsers();

    @GET("promo.php")
    Call<GetPromo> promo();

    @FormUrlEncoded
    @POST("token.php")
    Call<GetToken> register(
            @Field("token") String token
    );
}
