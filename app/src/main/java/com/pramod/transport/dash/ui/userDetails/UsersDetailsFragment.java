package com.pramod.transport.dash.ui.userDetails;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pramod.transport.adapter.UserInfoAdapter;
import com.pramod.transport.dash.fragments.fragementinterface.UsersDetailsView;
import com.pramod.transport.dash.fragments.fragementpresenter.UsersDetailsPresenter;
import com.pramod.transport.dash.fragments.framentmodel.UsersInfoDetails;
import com.pramod.transport.databinding.FragmentUsersDetailsBinding;

import java.util.List;


public  class UsersDetailsFragment extends Fragment implements UsersDetailsView {


   private FragmentUsersDetailsBinding fragmentUsersDetailsBinding;
   private View view;
   private RecyclerView recyclerView;
   private UsersDetailsPresenter usersDetailsPresenter;
   private UserInfoAdapter userInfoAdapter;
   private List<UsersInfoDetails> users;






    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUsersDetailsBinding = FragmentUsersDetailsBinding.inflate(inflater, container, false);
        view = fragmentUsersDetailsBinding.getRoot();

        fragmentUsersDetailsBinding.recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        userInfoAdapter = new UserInfoAdapter(getContext(),users);


        usersDetailsPresenter = new UsersDetailsPresenter(this);



        return view;
    }

    @Override
    public void onSucess(List<UsersInfoDetails> usersInfoDetails) {
        userInfoAdapter.setUsers(usersInfoDetails);
        fragmentUsersDetailsBinding.recylerView.setAdapter(userInfoAdapter);
        userInfoAdapter.notifyDataSetChanged();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Log.e("UserDetailsFragment", gson.toJson(usersInfoDetails));

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