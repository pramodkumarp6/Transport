package com.pramod.transport.dash.fragments.framentmodel;

import android.util.Log;

import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.dash.fragments.fragementinterface.PasswordChangeModelView;
import com.pramod.transport.dash.fragments.fragementpresenter.PasswordChangePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordChangeModel implements PasswordChangeModelView {
        private PasswordChangePresenter passwordChangePresenter;

        public PasswordChangeModel(PasswordChangePresenter passwordChangePresenter) {
                this.passwordChangePresenter = passwordChangePresenter;
        }

        @Override
        public void validate(String email, String password) {
                Log.e(email,"email");
                Log.e(password,"password");

                if(email.isEmpty()){
                        passwordChangePresenter.onError("Enter email");

                        return;
                }
                if(password.isEmpty()){
                        passwordChangePresenter.onError("Enter password");
                        return;
                }

                passwordChangePresenter.onShow();
                Call<PasswordChangeResponse> call = RetrofitClient.getInstance().getApi().passwordChange(email,password);
                call.enqueue(new Callback<PasswordChangeResponse>() {
                        @Override
                        public void onResponse(Call<PasswordChangeResponse> call, Response<PasswordChangeResponse> response) {
                        PasswordChangeResponse passwordChangeResponse = response.body();
                        if(passwordChangeResponse !=null){
                                passwordChangePresenter.onShow();

                        }else {
                                passwordChangePresenter.onError(response.body().getMessage());

                        }


                        }

                        @Override
                        public void onFailure(Call<PasswordChangeResponse> call, Throwable t) {

                        }
                });

        }
}
