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

    public void accountUpdate(String email, String password, String name, String school) {
        accountModel = new  AccountModel(this);
        accountModel.validate(email,password,name,school);

    }

    @Override
    public void onSucess() {
        accountView.onSucess();

    }

    @Override
    public void onError(String msg) {
        accountView.onError(msg);

    }

    @Override
    public void onHide() {
        accountView.onHide();

    }

    @Override
    public void onShow() {
        accountView.onShow();

    }


}
