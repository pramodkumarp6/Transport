package com.pramod.transport;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pramod.transport.databinding.ActivityUserForgetBinding;
import com.pramod.transport.interfaceuser.UserForgetView;
import com.pramod.transport.presenter.UserForgetPresenter;

public class UserForgetActivity extends AppCompatActivity implements UserForgetView {

    private ActivityUserForgetBinding mUserForgetBinding;
    private UserForgetPresenter userForgetPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserForgetBinding = ActivityUserForgetBinding.inflate(getLayoutInflater());
        View view = mUserForgetBinding.getRoot();
        setContentView(view);
        setTitle("UserForget");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        mUserForgetBinding.forgetButton.setOnClickListener(view1 -> {
            final String email = mUserForgetBinding.email.getText().toString();
            userForgetPresenter = new UserForgetPresenter(this);
            userForgetPresenter.UserForget(email);
        });


    }

    @Override
    public void onSucess() {
        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onHide() {
        progressDialog.hide();

    }

    @Override
    public void onShow() {
        progressDialog.show();

    }
}