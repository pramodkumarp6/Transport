package com.pramod.transport.presenter;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.interfaceuser.RegisterModelView;
import com.pramod.transport.interfaceuser.RegisterPreseneterView;
import com.pramod.transport.interfaceuser.RegisterView;
import com.pramod.transport.model.LoginModel;
import com.pramod.transport.model.RegisterModel;
import com.pramod.transport.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterPreseneterView {
    private RegisterView registerView;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
    }

    public void Register(String email, String password, String name, String school){
        registerModel = new RegisterModel(this);
        // Log.e("email",email);
        registerModel.validate(email,password,name,school);


    }

    @Override
    public void onSucess() {
        registerView.onSucess();

    }

    @Override
    public void onError(String msg) {
        registerView.onError(msg);

    }

    @Override
    public void onHide() {
       // registerView.onHide();

    }

    @Override
    public void onShow() {
      //  registerView.onShow();

    }
}
