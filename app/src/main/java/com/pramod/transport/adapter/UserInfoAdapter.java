package com.pramod.transport.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.pramod.transport.R;
import com.pramod.transport.dash.fragments.framentmodel.UsersInfoDetails;
import com.pramod.transport.dash.ui.userDetails.UsersDetailsFragment;
import com.pramod.transport.databinding.RecyclerRowBinding;
import com.pramod.transport.model.UserResponse;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {
    private Context context;
    private List<UsersInfoDetails> users;

    public UserInfoAdapter(Context context, List<UsersInfoDetails> users) {
        this.context = context;
        this.users = users;
    }

    public void setUsers(List<UsersInfoDetails> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding recyclerRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recycler_row, parent, false);
        return new ViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recyclerRowBinding.setUsers(users.get(position));


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private RecyclerRowBinding recyclerRowBinding;

        public ViewHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }



    }
}