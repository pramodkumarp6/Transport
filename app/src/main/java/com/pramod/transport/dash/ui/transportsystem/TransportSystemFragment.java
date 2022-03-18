package com.pramod.transport.dash.ui.transportsystem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pramod.transport.dash.fragments.fragementinterface.TransportView;
import com.pramod.transport.databinding.FragmentTransportSystemBinding;


public class TransportSystemFragment extends Fragment implements TransportView {
    private FragmentTransportSystemBinding fragmentTransportSystemBinding;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTransportSystemBinding=FragmentTransportSystemBinding.inflate(inflater, container, false);
         view = fragmentTransportSystemBinding.getRoot();
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
        fragmentTransportSystemBinding = null;
    }

}