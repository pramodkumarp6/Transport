package com.pramod.transport.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginPresenterView;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.LoginModel;
import com.pramod.transport.model.LoginResponse;
import com.pramod.transport.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter  implements LoginPresenterView {
    private LoginView view;
    private LoginModel loginModel;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }
    public LoginPresenter() {
        this.view = view;
    }

    public void Login(String email, String password) {

             loginModel = new LoginModel(this);
            // Log.e("email",email);
             loginModel.validate(email,password);

}


    @Override
    public void onSucess() {
        view.onSucess();

    }

    @Override
    public void onError(String msg) {
        view.onError(msg);

    }

    @Override
    public void onHide() {
        view.onHide();

    }

    @Override
    public void onShow() {
        view.onShow();

    }
}
