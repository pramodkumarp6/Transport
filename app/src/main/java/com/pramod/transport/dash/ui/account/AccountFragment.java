package com.pramod.transport.dash.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.pramod.transport.R;
import com.pramod.transport.dash.fragments.fragementinterface.AccountView;
import com.pramod.transport.dash.fragments.fragementpresenter.AccountPresenter;
import com.pramod.transport.databinding.FragmentAccountBinding;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.sharedPreference.SharedPrefManager;


public class AccountFragment extends Fragment implements AccountView {

    private FragmentAccountBinding fragmentAccountBinding;
    private ProgressDialog progressDialog;
    private AccountPresenter accountPresenter;
    private Account account;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentAccountBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account,container, false);

        View view = fragmentAccountBinding.getRoot();
        accountPresenter = new AccountPresenter(this,new Account(),getActivity());
        fragmentAccountBinding.setPresenter(accountPresenter);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");

        return view;
    }


    @Override
    public void onSucess(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onHide() {
            progressDialog.dismiss();

    }

    @Override
    public void onShow() {
        progressDialog.show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentAccountBinding = null;
    }

}