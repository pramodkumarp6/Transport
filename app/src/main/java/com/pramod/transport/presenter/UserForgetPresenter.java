package com.pramod.transport.presenter;

import com.pramod.transport.interfaceuser.UserForgetPresenterView;
import com.pramod.transport.interfaceuser.UserForgetView;
import com.pramod.transport.model.userforget.UserForgetModel;

public class UserForgetPresenter implements UserForgetPresenterView {
    private UserForgetView userForgetView;
    private UserForgetModel userForgetModel;

    public UserForgetPresenter(UserForgetView userForgetView) {
        this.userForgetView = userForgetView;
    }

    public void UserForget(String email) {
        userForgetModel = new UserForgetModel(this);
        userForgetModel.validate(email);

    }


    @Override
    public void onSucess() {
        userForgetView.onSucess();

    }

    @Override
    public void onError(String msg) {
        userForgetView.onError(msg);

    }

    @Override
    public void onHide() {
        userForgetView.onHide();

    }

    @Override
    public void onShow() {
        userForgetView.onShow();

    }
}
