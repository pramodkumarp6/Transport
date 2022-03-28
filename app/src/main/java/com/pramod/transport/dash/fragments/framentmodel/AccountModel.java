package com.pramod.transport.dash.fragments.framentmodel;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    public void validate(String id ,String email, String password, String name, String school) {
        Log.e("id frag",id);


        accountPresenter.onShow();
        Call<AccountResponse> call = RetrofitClient.getInstance().getApi().accountUpdate(id,email,password,name,school);
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {

                accountPresenter.onHide();
                AccountResponse accountResponse = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Log.e("Json", gson.toJson(accountResponse));

                if(!accountResponse.isError()){
                    accountPresenter.onShow();
                }else{
                    accountPresenter.onError(response.body().getMessage());

                }

            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {

            }
        });

    }
}
