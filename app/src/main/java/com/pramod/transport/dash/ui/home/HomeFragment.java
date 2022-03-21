package com.pramod.transport.dash.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pramod.transport.dash.fragments.fragementinterface.HomeView;
import com.pramod.transport.databinding.FragmentHomeBinding;

import java.util.List;


public abstract class HomeFragment extends Fragment implements HomeView {


    private FragmentHomeBinding fragmentHomeBinding;
    private ProgressDialog progressDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = fragmentHomeBinding.getRoot();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");

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