package com.pramod.transport;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.databinding.ActivityMainBinding;
import com.pramod.transport.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements LoginView {
    private ActivityMainBinding mainBinding;
    private RegisterPresenter registerPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        setTitle("Register");

        mainBinding.registerButton.setOnClickListener(view1 -> {

            String email = mainBinding.editTextemail.getText().toString();
            String password = mainBinding.editTextPassword.getText().toString();
            String name = mainBinding.name.getText().toString();
            String school = mainBinding.school.getText().toString();

            registerPresenter = new RegisterPresenter();
            registerPresenter.Register(email,password,name,school);
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


    }

    private void RegisterPresenter() {
    }

    @Override
    public void onSucess() {
        progressDialog.show();

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