package com.pramod.transport.dash.fragments.fragementpresenter;

import com.pramod.transport.dash.fragments.fragementinterface.AccountPresenterView;
import com.pramod.transport.dash.fragments.fragementinterface.AccountView;
import com.pramod.transport.dash.fragments.framentmodel.AccountModel;

public class AccountPresenter implements AccountPresenterView {
    private AccountModel accountModel;
    private AccountView accountView;

    public AccountPresenter(AccountView accountView) {
        this.accountView = accountView;
    }

    public void accountUpdate() {

    }

    @Override
    public void onSucess() {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onHide() {

    }

    @Override
    public void onShow() {

    }


}
