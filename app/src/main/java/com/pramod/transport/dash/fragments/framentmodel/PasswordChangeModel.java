package com.pramod.transport.dash.fragments.framentmodel;

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
                Call<PasswordChangeResponse> call = RetrofitClient.getInstance().getApi().passwordChange();
                call.enqueue(new Callback<PasswordChangeResponse>() {
                        @Override
                        public void onResponse(Call<PasswordChangeResponse> call, Response<PasswordChangeResponse> response) {

                        }

                        @Override
                        public void onFailure(Call<PasswordChangeResponse> call, Throwable t) {

                        }
                });

        }
}
