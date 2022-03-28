package com.pramod.transport.dash.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.pramod.transport.dash.fragments.fragementinterface.HomeView;
import com.pramod.transport.databinding.FragmentHomeBinding;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.sharedPreference.SharedPrefManager;


public  class HomeFragment extends Fragment implements HomeView {


    private FragmentHomeBinding fragmentHomeBinding;
    private ProgressDialog progressDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = fragmentHomeBinding.getRoot();


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");

        User user = SharedPrefManager.getInstance(getActivity()).getUser();

        fragmentHomeBinding.id.setText(String.valueOf(user.getId()));
        fragmentHomeBinding.name.setText(user.getName());
        fragmentHomeBinding.email.setText(user.getEmail());
        fragmentHomeBinding.school.setText(user.getSchool());
        return view;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }

}