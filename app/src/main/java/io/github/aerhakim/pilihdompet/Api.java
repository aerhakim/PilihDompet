package io.github.aerhakim.pilihdompet;



import io.github.aerhakim.pilihdompet.model.FetchUserResponse;
import io.github.aerhakim.pilihdompet.model.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("fetchusers.php")
    Call<FetchUserResponse> fetchAllUsers();

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> register(
            @Field("token") String token
    );
}
