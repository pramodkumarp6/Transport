package com.pramod.transport.model.userforget;

import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.interfaceuser.UserModelView;
import com.pramod.transport.presenter.UserForgetPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserForgetModel implements UserModelView {
    private UserForgetPresenter userForgetPresenter;

    public UserForgetModel(UserForgetPresenter userForgetPresenter) {
        this.userForgetPresenter = userForgetPresenter;
    }

    @Override
    public void validate(String email) {
        if (email.isEmpty()) {
            userForgetPresenter.onError("Enter Email id");
            return;
        }
        Call<UserForgetResponse> call = RetrofitClient.getInstance().getApi().userForget(email);
        call.enqueue(new Callback<UserForgetResponse>() {
            @Override
            public void onResponse(Call<UserForgetResponse> call, Response<UserForgetResponse> response) {
                  UserForgetResponse userForgetResponse = response.body();
                  if(!userForgetResponse.isError()){
                      userForgetPresenter.onSucess();

                  }
                  userForgetPresenter.onError(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<UserForgetResponse> call, Throwable t) {

            }
        });
    }
}
