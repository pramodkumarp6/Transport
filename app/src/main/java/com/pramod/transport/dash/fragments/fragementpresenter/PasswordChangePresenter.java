package com.pramod.transport.dash.fragments.fragementpresenter;

import com.pramod.transport.dash.fragments.fragementinterface.PasswordChangePreseneterView;
import com.pramod.transport.dash.fragments.fragementinterface.PasswordchangeView;
import com.pramod.transport.dash.fragments.framentmodel.PasswordChangeModel;

public class PasswordChangePresenter implements PasswordChangePreseneterView {
    private PasswordChangeModel passwordChangeModel;
    private PasswordchangeView passwordchangeView;

    public PasswordChangePresenter(PasswordchangeView passwordchangeView) {
        this.passwordchangeView = passwordchangeView;
    }
    public void passwordChange(){

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
