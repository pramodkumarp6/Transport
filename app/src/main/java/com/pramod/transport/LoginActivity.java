package com.pramod.transport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.pramod.transport.dash.ProfileActivity;
import com.pramod.transport.dash.UserDetails;
import com.pramod.transport.databinding.ActivityLoginBinding;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.signin.Users;
import com.pramod.transport.presenter.LoginPresenter;
import com.pramod.transport.sharedPreference.SharedPrefManager;

import java.util.List;

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
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


        loginBinding.textViewRegister1.setOnClickListener(view1 -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

        });

        loginBinding.textViewRegister2.setOnClickListener(view1 -> {
            startActivity(new Intent(LoginActivity.this, UserForgetActivity.class));

        });




        loginBinding.buttonLogin.setOnClickListener(view1 -> {
            SigIn();
        });

    }

    public void SigIn() {
        final String email = loginBinding.email.getText().toString().trim();
        final String password = loginBinding.password.getText().toString().trim();
        presenter = new LoginPresenter(this);
        presenter.Login(email, password);

    }




    @Override
    public void onSucess(Users users) {

        String tata = users.getSchool();


        Log.d(tata,"Love");


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
        progressDialog.dismiss();
    }

    @Override
    public void onDestry() {
        super.onDestroy();

        presenter = null;

    }

}