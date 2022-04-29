package com.pramod.transport.dash.fragments.fragementpresenter;

import android.content.Context;
import android.util.Log;

import androidx.databinding.ObservableField;

import com.pramod.transport.dash.fragments.fragementinterface.AccountPresenterView;
import com.pramod.transport.dash.fragments.fragementinterface.AccountView;
import com.pramod.transport.dash.fragments.framentmodel.AccountModel;
import com.pramod.transport.dash.ui.account.Account;
import com.pramod.transport.model.signin.User;
import com.pramod.transport.sharedPreference.SharedPrefManager;

public class AccountPresenter implements AccountPresenterView {
    private AccountModel accountModel;
    private AccountView accountView;
    private Account account;
    private Context context;




    public ObservableField<String> email = new ObservableField<>();

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> school =new ObservableField<>();


    public AccountPresenter(AccountView accountView, Account account,Context context) {
        this.accountView = accountView;
        this.account = account;
        this.context = context;
        View();

    }
    public void View(){

        User user = SharedPrefManager.getInstance(context).getUser();
        account = new Account();
        account.setEmail("user.getEmail()");
        Log.e(user.getSchool(),"school");
        account.setName(user.getName());
        account.setSchool(user.getSchool());

    }







    public void onUpdate(){
        User user = SharedPrefManager.getInstance(context).getUser();
        final String id = String.valueOf(user.getId());
        Account account = new Account();
         account.setEmail(email.get());
        account.setName(name.get());
        account.setSchool(school.get());

        accountModel = new  AccountModel(this);
        accountModel.validate(id,account.getEmail(),account.getName(),account.getSchool());



    }


    public void accountUpdate(String id, String email, String name, String school) {

    }

    @Override
    public void onSucess(String message) {
        accountView.onSucess(message);

    }

    @Override
    public void onError(String msg) {
        accountView.onError(msg);

    }

    @Override
    public void onHide() {
        accountView.onHide();

    }

    @Override
    public void onShow() {
        accountView.onShow();

    }


}
