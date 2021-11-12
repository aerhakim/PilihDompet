package io.github.aerhakim.pilihdompet.Rest;



import io.github.aerhakim.pilihdompet.model.GetEwallet;
import io.github.aerhakim.pilihdompet.model.GetToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("fetchusers.php")
    Call<GetEwallet> fetchAllUsers();

    @FormUrlEncoded
    @POST("register.php")
    Call<GetToken> register(
            @Field("token") String token
    );
}
