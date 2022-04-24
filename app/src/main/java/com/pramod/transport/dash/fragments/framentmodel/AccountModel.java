package com.pramod.transport.dash.fragments.framentmodel;

import android.util.Log;

import androidx.annotation.NonNull;

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
    public void validate(String id ,String email, String name, String school) {





        accountPresenter.onShow();
        Call<AccountResponse> call = RetrofitClient.getInstance().getApi().accountUpdate(id,email,name,school);
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(@NonNull Call<AccountResponse> call, Response<AccountResponse> response) {

                accountPresenter.onShow();
                AccountResponse accountResponse = response.body();


                if(!accountResponse.isError()){
                    accountPresenter.onHide();
                    accountPresenter.onSucess(accountResponse.getMessage());
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Log.e("Json", gson.toJson(accountResponse));
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
