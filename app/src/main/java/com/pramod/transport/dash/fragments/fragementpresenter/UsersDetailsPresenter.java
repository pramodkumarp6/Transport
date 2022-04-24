package com.pramod.transport.dash.fragments.fragementpresenter;

import com.pramod.transport.dash.fragments.fragementinterface.UserDetailsPresenterView;
import com.pramod.transport.dash.fragments.fragementinterface.UsersDetailsView;
import com.pramod.transport.dash.fragments.framentmodel.UserDetailsModel;
import com.pramod.transport.dash.fragments.framentmodel.UsersInfoDetails;

import java.util.List;

public class UsersDetailsPresenter implements UserDetailsPresenterView {
    private UserDetailsModel userDetailsModel;
    private UsersDetailsView usersDetailsView;

    public UsersDetailsPresenter(UsersDetailsView usersDetailsView) {
        this.usersDetailsView = usersDetailsView;
        userDetailsModel = new UserDetailsModel(this);
        userDetailsModel.detail();
    }


    @Override
    public void onSucess(List<UsersInfoDetails> usersInfoDetails) {
        usersDetailsView.onSucess(usersInfoDetails);

    }

    @Override
    public void onError(String msg) {
        usersDetailsView.onError(msg);

    }

    @Override
    public void onHide() {

    }

    @Override
    public void onShow() {

    }
}
