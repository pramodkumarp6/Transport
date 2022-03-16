package com.pramod.transport.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginModelView;
import com.pramod.transport.presenter.LoginPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginModelView {
    private LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Override
    public void validate(String email, String password) {
        Log.d("password",password);
        Log.d(email,"email");

        if(email.isEmpty()){
            loginPresenter.onError("Enter Email id");
            return;
        }
        if(password.isEmpty()){
            loginPresenter.onError("Enter password and id!");
            return;
        }
        loginPresenter.onShow();

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                loginPresenter.onHide();
                if (!loginResponse.isError()) {
                    loginPresenter.onSucess();
                    List<User> userList = response.body().getUserList();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("Json", gson.toJson(loginResponse));

                } else {
                    loginPresenter.onError(response.body().getMessage());
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
