package com.pramod.transport.dash.ui.userDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pramod.transport.dash.fragments.fragementinterface.UsersDetailsView;
import com.pramod.transport.databinding.FragmentUsersDetailsBinding;

import java.util.List;


public abstract class UsersDetailsFragment extends Fragment implements UsersDetailsView {
    @Expose
    @SerializedName("users")
    private List<UsersEntity> tuUsers;
    @Expose
    @SerializedName("error")
    private boolean tuError;
    private FragmentUsersDetailsBinding fragmentUsersDetailsBinding;
    private View view;

    public List<UsersEntity> getUsers() {
        return tuUsers;
    }

    public void setUsers(List<UsersEntity> tuUsers) {
        this.tuUsers = tuUsers;
    }

    public boolean getError() {
        return tuError;
    }

    public void setError(boolean tuError) {
        this.tuError = tuError;
    }

    public FragmentUsersDetailsBinding getFragmentUsersDetailsBinding() {
        return fragmentUsersDetailsBinding;
    }

    public void setFragmentUsersDetailsBinding(FragmentUsersDetailsBinding fragmentUsersDetailsBinding) {
        this.fragmentUsersDetailsBinding = fragmentUsersDetailsBinding;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public static class UsersEntity {
        @Expose
        @SerializedName("school")
        private String tuSchool;
        @Expose
        @SerializedName("name")
        private String tuName;
        @Expose
        @SerializedName("email")
        private String tuEmail;
        @Expose
        @SerializedName("id")
        private int tuId;

        public String getSchool() {
            return tuSchool;
        }

        public void setSchool(String tuSchool) {
            this.tuSchool = tuSchool;
        }

        public String getName() {
            return tuName;
        }

        public void setName(String tuName) {
            this.tuName = tuName;
        }

        public String getEmail() {
            return tuEmail;
        }

        public void setEmail(String tuEmail) {
            this.tuEmail = tuEmail;
        }

        public int getId() {
            return tuId;
        }

        public void setId(int tuId) {
            this.tuId = tuId;
        }
    }


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