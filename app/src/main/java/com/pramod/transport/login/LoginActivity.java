package com.pramod.transport.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.pramod.transport.R;
import com.pramod.transport.databinding.ActivityLoginBinding;
import com.pramod.transport.register.RegisterActivity;
import com.pramod.transport.userforget.UserForgetActivity;
import com.pramod.transport.dash.UserDetails;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.signin.Users;
import com.pramod.transport.sharedPreference.SharedPrefManager;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding loginBinding;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        loginBinding.setPresenter(loginPresenter);

        setTitle("Login");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


        loginBinding.textViewRegister1.setOnClickListener(parm -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

        });

        loginBinding.textViewRegister2.setOnClickListener(parm -> {
            startActivity(new Intent(LoginActivity.this, UserForgetActivity.class));

        });
    }






    @Override
    public void onSucess(Users users) {

        SharedPrefManager.getInstance(LoginActivity.this).saveUser(users);

        Intent intent = new Intent(new Intent(this, UserDetails.class));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public void onError(String msg) {

        Snackbar.make(loginBinding.relative,msg,Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public void onShow() {
        progressDialog.show();



    }

    @Override
    public void onHide() {
        progressDialog.cancel();
    }


    }

