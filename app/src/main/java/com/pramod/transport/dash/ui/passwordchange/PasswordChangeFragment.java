package com.pramod.transport.dash.ui.passwordchange;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pramod.transport.dash.fragments.fragementinterface.PasswordchangeView;
import com.pramod.transport.dash.fragments.fragementpresenter.PasswordChangePresenter;
import com.pramod.transport.databinding.FragmentPasswordChangeBinding;


public class PasswordChangeFragment extends Fragment implements PasswordchangeView {
    private FragmentPasswordChangeBinding passwordChangeBinding;
    private PasswordChangePresenter passwordChangePresenter;
    private ProgressDialog progressDialog;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        passwordChangeBinding = FragmentPasswordChangeBinding.inflate(inflater, container, false);
        passwordChangeBinding.getRoot();
        View view = passwordChangeBinding.getRoot();
        progressDialog = new ProgressDialog(getActivity());
        passwordChangeBinding.passwordChangeButton.setOnClickListener(view1 -> {
            final String email = passwordChangeBinding.editTextemail.getText().toString().trim();
            final String password = passwordChangeBinding.changePassword.getText().toString().trim();
            final String confirmpassword = passwordChangeBinding.confirmPassword.getText().toString().trim();
            passwordChangePresenter = new PasswordChangePresenter(this);
            passwordChangePresenter.passwordChange(email,password,confirmpassword);

        });
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        return view;
    }

    @Override
    public void onSucess() {
        Toast.makeText(getActivity(), "Msg", Toast.LENGTH_SHORT).show();

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
}