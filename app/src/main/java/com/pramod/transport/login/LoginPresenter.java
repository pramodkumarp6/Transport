package com.pramod.transport.login;
import androidx.databinding.ObservableField;
import com.pramod.transport.interfaceuser.LoginPresenterView;
import com.pramod.transport.interfaceuser.LoginView;
import com.pramod.transport.model.signin.Users;


public class LoginPresenter  implements LoginPresenterView {
    private LoginView view;
    private LoginModel loginModel;
    public ObservableField<String>email = new ObservableField<>();
    public ObservableField<String>password = new ObservableField<>();

    public LoginPresenter(LoginView view) {
        this.view = view;
        initFields();
    }


    private void initFields() {
        email = new ObservableField<>();
        password = new ObservableField<>();


    }


    public void  onLogin(){
        Login();

    }


    public void Login() {
        loginModel = new LoginModel(this);
        loginModel.validate(email.get(),password.get());

}





    @Override
    public void onSucess(Users users) {
         view.onSucess(users);

    }

    @Override
    public void onError(String msg) {
        view.onError(msg);

    }



    @Override
    public void onShow() {
        view.onShow();

    }
    @Override
    public void onHide() {
        view.onHide();

    }
}
