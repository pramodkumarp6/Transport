package com.pramod.transport.login;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.pramod.transport.R;
import com.pramod.transport.app.ConnectionReciever;
import com.pramod.transport.databinding.ActivityLoginBinding;
import com.pramod.transport.register.RegisterActivity;
import com.pramod.transport.userforget.UserForgetActivity;
import com.pramod.transport.dash.UserDetails;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.signin.Users;
import com.pramod.transport.sharedPreference.SharedPrefManager;

import kotlin.Suppress;


public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding loginBinding;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    private BroadcastReceiver broadcastReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        broadcastReceiver = new ConnectionReciever(this);
        registerNetworkBroadcast();

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
    protected  void registerNetworkBroadcast(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected  void unregisterNetwork(){
        try{
            unregisterReceiver(broadcastReceiver);
        }catch (IllegalArgumentException e){
            e.printStackTrace();

        }
    }

    }

