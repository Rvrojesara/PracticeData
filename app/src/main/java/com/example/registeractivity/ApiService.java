package com.example.registeractivity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ApiService {
    @FormUrlEncoded
    @POST("register.php")
    Call<ApiResponse> registerUser(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("email")    String email,
            @Field("password") String password
    );
}
