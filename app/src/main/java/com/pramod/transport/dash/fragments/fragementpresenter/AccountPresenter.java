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

    public void accountUpdate(String id, String email, String name, String school) {
        accountModel = new  AccountModel(this);
        accountModel.validate(id,email,name,school);

    }

    @Override
    public void onSucess(String message) {
        accountView.onSucess(message);

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
