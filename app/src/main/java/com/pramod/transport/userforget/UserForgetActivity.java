package com.pramod.transport.userforget;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.pramod.transport.app.ConnectionReciever;
import com.pramod.transport.databinding.ActivityUserForgetBinding;
import com.pramod.transport.interfaceuser.UserForgetView;

public class UserForgetActivity extends AppCompatActivity implements UserForgetView {

    private ActivityUserForgetBinding mUserForgetBinding;
    private UserForgetPresenter userForgetPresenter;
    private ProgressDialog progressDialog;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserForgetBinding = ActivityUserForgetBinding.inflate(getLayoutInflater());
        View view = mUserForgetBinding.getRoot();
        setContentView(view);
        setTitle("UserForget");

        broadcastReceiver = new ConnectionReciever(this);
        registerNetworkBroadcast();


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