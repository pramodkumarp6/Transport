package com.pramod.transport.register;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.pramod.transport.interfaceuser.RegisterPreseneterView;
import com.pramod.transport.interfaceuser.RegisterView;

public class RegisterPresenter implements RegisterPreseneterView {

    private final RegisterView registerView;
    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> name;
    public ObservableField<String> school;

    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView registerView) {

        this.registerView = registerView;
        initFields();
    }

    private void initFields() {
        email = new ObservableField<>();
        password = new ObservableField<>();
        name = new ObservableField<>();
        school = new ObservableField<>();


    }


    public void onRegister() {

        Log.d(email.get(), "email");
        Log.e(password.get(), "password");
        Log.e(name.get(), "name");
        Log.d(school.get(), "school");
        registerModel = new RegisterModel(this);
        registerModel.validate(email.get(), password.get(), name.get(), school.get());


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
        registerView.onHide();

    }

    @Override
    public void onShow() {
        registerView.onShow();

    }
}
