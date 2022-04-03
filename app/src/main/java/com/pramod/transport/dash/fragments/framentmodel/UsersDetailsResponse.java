package com.pramod.transport.dash.fragments.framentmodel;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersDetailsResponse {
    private boolean error;
    @SerializedName("users")
    private List<UsersInfoDetails>usersInfoDetails;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<UsersInfoDetails> getUsersInfoDetails() {
        return usersInfoDetails;
    }

    public void setUsersInfoDetails(List<UsersInfoDetails> usersInfoDetails) {
        this.usersInfoDetails = usersInfoDetails;
    }
}
