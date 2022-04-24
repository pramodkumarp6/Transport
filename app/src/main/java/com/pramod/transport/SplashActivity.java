package com.pramod.transport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.pramod.transport.databinding.ActivitySplashBinding;
import com.pramod.transport.login.LoginActivity;


public class SplashActivity extends AppCompatActivity  {
    private ActivitySplashBinding splashBinding;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        getSupportActionBar().hide();

       Thread t = new Thread() {
            public void run() {

                try {

                    sleep(1000);

                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }



}
