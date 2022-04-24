package com.pramod.transport.dash.fragments.fragementinterface;

public interface AccountPresenterView {
    void onSucess(String message);
    void onError(String msg);
    void onHide();
    void onShow();
}
