package com.pramod.transport.dash.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pramod.transport.dash.fragments.fragementinterface.AccountView;
import com.pramod.transport.dash.fragments.fragementpresenter.AccountPresenter;
import com.pramod.transport.databinding.FragmentAccountBinding;


public class Account extends Fragment implements AccountView {

    private FragmentAccountBinding fragmentAccountBinding;
    private AccountPresenter accountPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);
        fragmentAccountBinding.updateButton.setOnClickListener(view1 -> {
            fragmentAccountBinding.editTextemail.getText().toString().trim();
            fragmentAccountBinding.editTextemail.getText().toString().trim();
            fragmentAccountBinding.editTextemail.getText().toString().trim();
            fragmentAccountBinding.editTextemail.getText().toString().trim();
            accountPresenter = new AccountPresenter(this);
            accountPresenter.accountUpdate();
        });

        return fragmentAccountBinding.getRoot();
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