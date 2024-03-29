package com.pramod.transport.app;

import com.pramod.transport.dash.fragments.framentmodel.AccountResponse;
import com.pramod.transport.dash.fragments.framentmodel.PasswordChangeResponse;
import com.pramod.transport.dash.fragments.framentmodel.UsersDetailsResponse;
import com.pramod.transport.model.signup.RegisterResponse;
import com.pramod.transport.model.signin.LoginResponse;
import com.pramod.transport.model.userforget.UserForgetResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("/simple/public/userlogin")
    Observable<LoginResponse> userLogin(@Field("email") String email,
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

    @FormUrlEncoded
    @POST("/simple/public/updateuser/{id}")
    Call<AccountResponse> accountUpdate(@Path("id") String id,
                                        @Field("email") String email,

                                        @Field("name") String name,
                                        @Field("school") String school);
    @FormUrlEncoded
    @POST("/simple/public/updatepassword")
    Call<PasswordChangeResponse> passwordChange(
                                                @Field("currentpassword") String currentpassword,
                                                @Field("newpassword") String newpassword,
                                                @Field("email") String email);

     @GET("/simple/public/allusers")
     Observable<UsersDetailsResponse> userdetails();
}
