package com.pramod.transport.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginModelView;
import com.pramod.transport.login.LoginPresenter;
import com.pramod.transport.model.signin.LoginResponse;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.model.signin.Users;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginModelView {
    private final LoginPresenter loginPresenter;
    private Context context;

    public LoginModel(LoginPresenter loginPresenter, Context context) {
        this.loginPresenter = loginPresenter;
        this.context = context;
    }



    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Override
    public void validate(@NonNull String email, String password) {


        if (TextUtils.isEmpty(email)) {
            loginPresenter.onError("Enter Email id");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            loginPresenter.onError("Enter password and id!");
            return;
        }
        loginPresenter.onShow();
        Observable<LoginResponse> observable = RetrofitClient.getInstance().getApi().userLogin(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginResponse response) {
                loginPresenter.onHide();
                if (!response.isError()) {
                    User user  = response.getUser();
                    //int  id = user.getId();
                    Users users = new Users(user.getId(),user.getEmail(),user.getName(),user.getSchool());

                    loginPresenter.onSucess(users);

                } else {
                    loginPresenter.onError(response.getMessage());
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
