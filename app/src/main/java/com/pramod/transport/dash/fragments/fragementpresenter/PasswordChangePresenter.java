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
    public void passwordChange( String currentpassword, String newpassword,String email){
        passwordChangeModel = new PasswordChangeModel(this);
        passwordChangeModel.validate(currentpassword,newpassword,email);


    }

    @Override
    public void onSucess(String msg) {
        passwordchangeView.onSucess(msg);

    }

    @Override
    public void onError(String msg) {
              passwordchangeView.onError(msg);
    }

    @Override
    public void onHide() {
        passwordchangeView.onHide();

    }

    @Override
    public void onShow() {
        passwordchangeView.onShow();

    }
}
