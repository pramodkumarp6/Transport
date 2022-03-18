package com.pramod.transport.dash.ui.account;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pramod.transport.dash.fragments.fragementinterface.AccountView;
import com.pramod.transport.dash.fragments.fragementpresenter.AccountPresenter;
import com.pramod.transport.databinding.FragmentAccountBinding;


public class AccountFragment extends Fragment implements AccountView {

    private FragmentAccountBinding fragmentAccountBinding;
    private ProgressDialog progressDialog;
    private AccountPresenter accountPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = fragmentAccountBinding.getRoot();
        fragmentAccountBinding.updateButton.setOnClickListener(view1 -> {
            final String email = fragmentAccountBinding.email.getText().toString().trim();
            final String password = fragmentAccountBinding.password.getText().toString().trim();
            final String name = fragmentAccountBinding.name.getText().toString().trim();
            final String school = fragmentAccountBinding.school.getText().toString().trim();
            accountPresenter = new AccountPresenter(this);
            accountPresenter.accountUpdate(email,password,name,school);
        });
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");

        return view;
    }


    @Override
    public void onSucess() {
        Toast.makeText(getActivity(), "Sucess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onHide() {
            progressDialog.hide();
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