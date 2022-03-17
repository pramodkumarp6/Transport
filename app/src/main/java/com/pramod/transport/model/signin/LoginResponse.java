package com.pramod.transport.model.signin;

import com.pramod.transport.model.signin.User;

import java.util.List;

public class LoginResponse {
    private boolean error;
    private String message;

    private List<User> userList;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
