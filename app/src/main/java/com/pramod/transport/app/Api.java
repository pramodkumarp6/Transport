package com.pramod.transport.app;

import com.pramod.transport.model.DeflaultResponse;
import com.pramod.transport.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/simple/public/userlogin")
    Call<LoginResponse> userLogin(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("/simple/public/createuser")
    Call<DeflaultResponse> userRegister(@Field("email")  String email,
                                        @Field("password") String password,
                                        @Field("name")String name,
                                        @Field("school")String school);
    @FormUrlEncoded
    @POST("/simple/public/userForget")
    Call<DeflaultResponse> userForget(@Field("email") String email);

}
