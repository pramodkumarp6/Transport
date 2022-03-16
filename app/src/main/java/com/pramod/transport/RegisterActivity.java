package com.pramod.transport;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.databinding.ActivityMainBinding;
import com.pramod.transport.interfaceuser.RegisterView;
import com.pramod.transport.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterView {
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
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        mainBinding.registerButton.setOnClickListener(view1 -> {

            String email = mainBinding.editTextemail.getText().toString();
            String password = mainBinding.editTextPassword.getText().toString();
            String name = mainBinding.name.getText().toString();
            String school = mainBinding.school.getText().toString();

            registerPresenter = new RegisterPresenter(this);
            registerPresenter.Register(email,password,name,school);
        });



    }



    @Override
    public void onSucess() {
        Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();



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