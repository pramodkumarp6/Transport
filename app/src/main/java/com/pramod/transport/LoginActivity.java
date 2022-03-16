package com.pramod.transport;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.dash.ProfileActivity;
import com.pramod.transport.databinding.ActivityLoginBinding;
import com.pramod.transport.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding loginBinding;
    private LoginPresenter presenter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);
        setTitle("Login");

        loginBinding.textViewRegister1.setOnClickListener(view1 ->{
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });

        loginBinding.textViewRegister2.setOnClickListener(view1->{
            startActivity(new Intent(LoginActivity.this,UserForgetActivity.class));
        });

        loginBinding.buttonLogin.setOnClickListener(view1-> {
                String email = loginBinding.email.getText().toString();
                String password = loginBinding.password.getText().toString();
                presenter = new LoginPresenter(this);
                presenter.Login(email,password);


        });

    }





    @Override
    public void onSucess() {
        startActivity(new Intent(this, ProfileActivity.class));
        finish();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

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