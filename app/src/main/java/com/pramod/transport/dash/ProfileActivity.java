package com.pramod.transport.dash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pramod.transport.databinding.ActivityProfileBinding;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.sharedPreference.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding activityProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = activityProfileBinding.getRoot();
        setContentView(view);
        setTitle("Dashobar");

        User user = SharedPrefManager.getInstance(this).getUser();
        activityProfileBinding.id.setText(String.valueOf(user.getId()));
        activityProfileBinding.name.setText(user.getName());
        activityProfileBinding.email.setText(user.getEmail());
        activityProfileBinding.school.setText(user.getSchool());

    }
}