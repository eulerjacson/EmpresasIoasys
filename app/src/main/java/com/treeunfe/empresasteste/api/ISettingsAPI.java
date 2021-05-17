package com.treeunfe.empresasteste.api;

import com.treeunfe.empresasteste.entity.Enterprises;
import com.treeunfe.empresasteste.entity.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ISettingsAPI {

    /// AUTH
    @FormUrlEncoded
    @POST("users/auth/sign_in")
    Call<User> login(@Field("email") String email, @Field("password") String password);

    @GET("enterprises")
    Call<Enterprises> getEnterprises(@Header("access-token") String accessToken, @Header("uid") String uid, @Header("client") String client, @Query("name") String query);
}