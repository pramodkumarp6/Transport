package com.pramod.transport.dash.fragments.fragementinterface;

import com.pramod.transport.dash.fragments.framentmodel.UsersInfoDetails;

import java.util.List;

public interface UserDetailsPresenterView {

    void onSucess(List<UsersInfoDetails> usersInfoDetails);
    void onError(String msg);
    void onHide();
    void onShow();
}
