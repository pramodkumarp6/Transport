package com.pramod.transport.interfaceuser;

import com.pramod.transport.model.signin.User;
import com.pramod.transport.model.signin.Users;

import java.util.List;

public interface RegisterPreseneterView {
    void onSucess();
    void onError(String msg);
    void onHide();
    void onShow();
}
