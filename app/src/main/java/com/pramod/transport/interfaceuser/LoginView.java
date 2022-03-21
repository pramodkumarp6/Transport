package com.pramod.transport.interfaceuser;

import com.pramod.transport.model.signin.Users;

import java.util.List;

public interface LoginView {
    void onSucess(Users users);
    void onError(String msg);
    void onHide();
    void onShow();


    void onDestry();


}
