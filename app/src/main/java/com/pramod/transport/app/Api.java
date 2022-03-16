package com.pramod.transport.app;

import com.pramod.transport.model.RegisterResponse;
import com.pramod.transport.model.LoginResponse;
import com.pramod.transport.model.UserForgetResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("/simple/public/userlogin")
    Call<LoginResponse> userLogin(@Field("email") String email,
                                  @Field("password") String password);

    @FormUrlEncoded
    @POST("/simple/public/createuser")
    Call<RegisterResponse> userRegister(@Field("email")  String email,
                                        @Field("password") String password,
                                        @Field("name")String name,
                                        @Field("school")String school);
    @FormUrlEncoded
    @POST("/simple/public/userForget")
    Call<UserForgetResponse> userForget(@Field("email") String email);

}
