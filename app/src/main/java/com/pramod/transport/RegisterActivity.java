package com.pramod.transport;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pramod.transport.databinding.ActivityMainBinding;
import com.pramod.transport.interfaceuser.RegisterView;
import com.pramod.transport.presenter.RegisterPresenter;

import java.util.Formatter;

public  class RegisterActivity extends AppCompatActivity implements RegisterView {

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
            String DeviceId =  Build.DEVICE ;
            /*WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
            String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
*/
            String information1 = "Device id = " + Build.DEVICE + "\n" + "Device Model = " + Build.MODEL + "\n";
               Log.e("DeviceId",DeviceId);
            registerPresenter = new RegisterPresenter(this);
            registerPresenter.Register(email, password, name, school);
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
        progressDialog.dismiss();

    }

    @Override
    public void onShow() {
        progressDialog.show();

    }




}