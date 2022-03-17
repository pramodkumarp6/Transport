package com.pramod.transport.presenter;

import com.pramod.transport.interfaceuser.RegisterPreseneterView;
import com.pramod.transport.interfaceuser.RegisterView;
import com.pramod.transport.model.signup.RegisterModel;

public class RegisterPresenter implements RegisterPreseneterView {
    private final RegisterView registerView;
    private RegisterModel registerModel;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
    }

    public void Register(String email, String password, String name, String school) {
        registerModel = new RegisterModel(this);

        registerModel.validate(email, password, name, school);


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
