package com.pramod.transport.dash.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pramod.transport.R;
import com.pramod.transport.dash.fragments.fragementinterface.PasswordchangeView;
import com.pramod.transport.dash.fragments.fragementpresenter.PasswordChangePresenter;
import com.pramod.transport.databinding.FragmentPasswordChangeBinding;


public class PasswordChange extends Fragment implements PasswordchangeView {
    private FragmentPasswordChangeBinding passwordChangeBinding;
    private PasswordChangePresenter passwordChangePresenter;
    private ProgressDialog progressDialog ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        passwordChangeBinding = FragmentPasswordChangeBinding.inflate(inflater, container, false);

        passwordChangeBinding.getRoot();
       // progressDialog = new ProgressDialog(this)
        passwordChangeBinding.passwordChangeButton.setOnClickListener(view -> {
            passwordChangeBinding.editTextemail.getText().toString().trim();
            passwordChangeBinding.changePassword.getText().toString().trim();
            passwordChangeBinding.confirmPassword.getText().toString().trim();
            passwordChangePresenter = new PasswordChangePresenter(this);
            passwordChangePresenter.passwordChange();

        });
        return passwordChangeBinding.getRoot();
    }

    @Override
    public void onSucess() {

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