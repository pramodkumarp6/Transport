package com.pramod.transport.presenter;

import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserForgetPresenter {




    public void  UserForget(String email){
       Call<RegisterResponse> call= RetrofitClient.getInstance().getApi().userForget(email);
       call.enqueue(new Callback<RegisterResponse>() {
           @Override
           public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

           }

           @Override
           public void onFailure(Call<RegisterResponse> call, Throwable t) {

           }
       });
   }



}
