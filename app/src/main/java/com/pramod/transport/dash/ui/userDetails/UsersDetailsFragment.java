package com.pramod.transport.dash.ui.userDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.pramod.transport.dash.fragments.fragementinterface.UsersDetailsView;
import com.pramod.transport.databinding.FragmentUsersDetailsBinding;


public  class UsersDetailsFragment extends Fragment implements UsersDetailsView {


   private FragmentUsersDetailsBinding fragmentUsersDetailsBinding;
   private View view;
   private RecyclerView recyclerView;






    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUsersDetailsBinding = FragmentUsersDetailsBinding.inflate(inflater, container, false);
        view = fragmentUsersDetailsBinding.getRoot();
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

    public void onDestroyView() {
        super.onDestroyView();
        fragmentUsersDetailsBinding = null;
    }
}