package com.pramod.transport.presenter;

import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.model.DeflaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserForgetPresenter {




    public void  UserForget(String email){
       Call<DeflaultResponse> call= RetrofitClient.getInstance().getApi().userForget(email);
       call.enqueue(new Callback<DeflaultResponse>() {
           @Override
           public void onResponse(Call<DeflaultResponse> call, Response<DeflaultResponse> response) {

           }

           @Override
           public void onFailure(Call<DeflaultResponse> call, Throwable t) {

           }
       });
   }



}
