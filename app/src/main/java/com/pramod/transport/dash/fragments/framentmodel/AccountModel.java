package com.pramod.transport.dash.fragments.framentmodel;

import com.pramod.transport.app.RetrofitClient;
import com.pramod.transport.dash.fragments.fragementinterface.AccountModelView;
import com.pramod.transport.dash.fragments.fragementpresenter.AccountPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountModel implements AccountModelView {
    private AccountPresenter accountPresenter;

    public AccountModel(AccountPresenter accountPresenter) {
        this.accountPresenter = accountPresenter;
    }

    @Override
    public void validate(String email, String password, String name, String school) {


        accountPresenter.onShow();
        Call<AccountResponse> call = RetrofitClient.getInstance().getApi().accountUpdate();
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                accountPresenter.onHide();

            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {

            }
        });

    }
}
