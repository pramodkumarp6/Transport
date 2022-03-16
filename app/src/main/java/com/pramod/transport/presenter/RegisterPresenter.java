package com.pramod.transport.presenter;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.DeflaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter  {
    private LoginView view;



    public void Register(String email, String password, String name, String school){
        Log.e("email",email);
        Call<DeflaultResponse> call = RetrofitClient.getInstance().getApi().userRegister(email,password,name,school);
        call.enqueue(new Callback<DeflaultResponse>() {
            @Override
            public void onResponse(Call<DeflaultResponse> call, Response<DeflaultResponse> response) {
                   DeflaultResponse deflaultResponse = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Log.e("Json", gson.toJson(deflaultResponse));
            }

            @Override
            public void onFailure(Call<DeflaultResponse> call, Throwable t) {


            }
        });

    }

}
