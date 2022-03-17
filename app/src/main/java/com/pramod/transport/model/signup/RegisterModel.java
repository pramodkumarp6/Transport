package com.pramod.transport.model.signup;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.RegisterModelView;
import com.pramod.transport.presenter.RegisterPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModel implements RegisterModelView {
    private RegisterPresenter registerPresenter;

    public RegisterModel(RegisterPresenter registerPresenter) {
        this.registerPresenter = registerPresenter;
    }

    @Override
    public void validate(String email, String password, String name, String school) {
        if(email.isEmpty()){
            registerPresenter.onError("Enter Email id!");
            return;
        }
        if(password.isEmpty()){
            registerPresenter.onError("Enter Email id!");

            return;
        }
        if(name.isEmpty()){
            registerPresenter.onError("Enter Name !");

            return;
        }
        if(school.isEmpty()){
            registerPresenter.onError("Enter School Name!");

            return;
        }




        Log.e("email",email);
        Log.e("passw",password);
        Log.e("n",name);
        Log.e("s",school);

        registerPresenter.onShow();
        Call<RegisterResponse> call = RetrofitClient.getInstance().getApi().userRegister(email,password,name,school);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse deflaultResponse = response.body();
                registerPresenter.onHide();
                if(deflaultResponse.isError()){
                   registerPresenter.onSucess();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("Json", gson.toJson(deflaultResponse));
                }
                 registerPresenter.onError(response.body().getMessage());
                }



            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {


            }
        });
    }
}
