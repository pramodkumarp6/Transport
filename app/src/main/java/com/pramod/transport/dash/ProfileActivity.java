package com.pramod.transport.dash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pramod.transport.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding activityProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());

        View view = activityProfileBinding.getRoot();
        setContentView(view);
    }
}