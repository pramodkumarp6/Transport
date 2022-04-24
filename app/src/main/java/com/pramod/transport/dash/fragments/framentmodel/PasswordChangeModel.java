package com.pramod.transport.dash.fragments.framentmodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        public void validate( String currentpassword,String newpassword,String email) {

                Log.e(currentpassword,"currentpassword");
                Log.e(newpassword,"newpassword");
                Log.e(email,"email");


                if(email.isEmpty()){
                        passwordChangePresenter.onError("Enter email");

                        return;
                }
                if(currentpassword.isEmpty()){
                        passwordChangePresenter.onError("Enter  Current Password");
                        return;
                }

                if(newpassword.isEmpty()){
                        passwordChangePresenter.onError("Enter  New Password");
                        return;
                }

                passwordChangePresenter.onShow();
                Call<PasswordChangeResponse> call = RetrofitClient.getInstance().getApi().passwordChange(email,currentpassword,newpassword);
                call.enqueue(new Callback<PasswordChangeResponse>() {
                        @Override
                        public void onResponse(Call<PasswordChangeResponse> call, Response<PasswordChangeResponse> response) {
                        PasswordChangeResponse passwordChangeResponse = response.body();
                        passwordChangePresenter.onHide();
                        if(!passwordChangeResponse.isError()){
                                passwordChangePresenter.onShow();
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                Log.e("UserDetailsFragment", gson.toJson(passwordChangeResponse));
                                passwordChangePresenter.onSucess(response.body().getMessage());
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
