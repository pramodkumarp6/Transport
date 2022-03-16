package com.pramod.transport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.databinding.ActivityUserForgetBinding;
import com.pramod.transport.presenter.UserForgetPresenter;

public class UserForgetActivity extends AppCompatActivity  implements LoginView {

    private ActivityUserForgetBinding mUserForgetBinding;
    private UserForgetPresenter userForgetPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserForgetBinding  = ActivityUserForgetBinding.inflate(getLayoutInflater());
        View view =  mUserForgetBinding.getRoot();
        setContentView(view);
        setTitle("UserForget");

        mUserForgetBinding.forgetButton.setOnClickListener(view1->{
           String email= mUserForgetBinding.email.getText().toString();
            userForgetPresenter = new UserForgetPresenter();
            userForgetPresenter.UserForget(email);
        });


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