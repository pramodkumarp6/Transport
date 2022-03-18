package com.pramod.transport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pramod.transport.dash.ProfileActivity;
import com.pramod.transport.dash.UserDetails;
import com.pramod.transport.databinding.ActivityLoginBinding;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding loginBinding;
    private LoginPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);
        setTitle("Login");

        loginBinding.textViewRegister1.setOnClickListener(view1 -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        loginBinding.textViewRegister2.setOnClickListener(view1 -> {
            startActivity(new Intent(LoginActivity.this, UserForgetActivity.class));
        });

        loginBinding.buttonLogin.setOnClickListener(view1 -> {
            final String email = loginBinding.email.getText().toString().trim();
            final String password = loginBinding.password.getText().toString().trim();
            presenter = new LoginPresenter(this);
            presenter.Login(email, password);

        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
    }


    @Override
    public void onSucess() {
        startActivity(new Intent(this, UserDetails.class));
        finish();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onShow() {
        progressDialog.show();

    }
    @Override
    public void onHide() {
        progressDialog.hide();
    }
    @Override
    public void onDestry(){
        super.onDestroy();
        loginBinding = null;

}

}