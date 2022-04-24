package com.pramod.transport.register;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.RegisterModelView;
import com.pramod.transport.model.signup.RegisterResponse;
import com.pramod.transport.register.RegisterPresenter;

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


        if(TextUtils.isEmpty(email)){
            registerPresenter.onError("Please Enter Email Id");
            return ;
        }
        if(TextUtils.isEmpty(password)){
            registerPresenter.onError("Enter Password");
            return ;
        }

        if(TextUtils.isEmpty(name)){
            registerPresenter.onError("Enter Name!");
            return ;
        }

        if(TextUtils.isEmpty(school)){
            registerPresenter.onError("Enter School");
            return ;
        }


        Log.e("email",email);
        Log.e("passw",password);
        Log.e("name",name);
        Log.e("school",school);

        registerPresenter.onShow();
        Call<RegisterResponse> call = RetrofitClient.getInstance().getApi().userRegister(email,password,name,school);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, Response<RegisterResponse> response) {

                registerPresenter.onHide();
                if(response.code()== 201){
                    RegisterResponse registerResponse = response.body();
                    registerPresenter.onError("User created successfully");
                   registerPresenter.onSucess();
                   Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("Json", gson.toJson(registerResponse));
                }else if(response.code()==422){
                 registerPresenter.onError("User Already Exist");
                }
            }



            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, Throwable t) {


            }
        });
    }
}
