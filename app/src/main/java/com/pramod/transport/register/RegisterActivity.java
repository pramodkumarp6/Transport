package com.pramod.transport.register;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.pramod.transport.R;
import com.pramod.transport.app.ConnectionReciever;
import com.pramod.transport.databinding.ActivityRegisterBinding;
import com.pramod.transport.interfaceuser.RegisterView;

public class RegisterActivity extends AppCompatActivity  implements RegisterView {

    private ActivityRegisterBinding  registerBinding;
    private RegisterPresenter registerPresenter;
    private ProgressDialog progressDialog;
    private BroadcastReceiver broadcastReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        progressDialog = new ProgressDialog(this);
        broadcastReceiver = new ConnectionReciever(this);
        registerNetworkBroadcast();


        registerPresenter = new RegisterPresenter(this);
        registerBinding.setPresenter(registerPresenter);

    }

    @Override
    public void onSucess() {

       Toast.makeText(this,"Sucessfully",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onHide() {
        progressDialog.dismiss();


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