package com.pramod.transport.dash.fragments.fragementinterface;

import com.pramod.transport.dash.fragments.framentmodel.UsersInfoDetails;

import java.util.List;

public interface UsersDetailsView {

    void onSucess(List<UsersInfoDetails> usersInfoDetails);
    void onError(String msg);
    void onHide();
    void onShow();
}
