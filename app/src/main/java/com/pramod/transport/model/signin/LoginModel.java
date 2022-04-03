package com.pramod.transport.model.signin;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.LoginModelView;
import com.pramod.transport.presenter.LoginPresenter;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginModelView {
    private final LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter, Context context) {
        this.loginPresenter = loginPresenter;
        this.context = context;
    }

    private Context context;


    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Override
    public void validate(@NonNull String email, String password) {
        Log.d("password", password);
        Log.d(email, "email");

        if (email.isEmpty()) {
            loginPresenter.onError("Enter Email id");
            return;
        }
        if (password.isEmpty()) {
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
                LoginResponse loginResponse = response;
                if (!loginResponse.isError()) {

                    User user  = loginResponse.getUser();
                    int  id = user.getId();
                    String email = user.getEmail();
                    String name = user.getName();
                    String school = user.getName();

                    Users users = new Users(id,email,name,school);

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
