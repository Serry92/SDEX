package com.example.greentech_android.sdex.login;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class LoginPresenterImplementer implements LoginPresenter {
    private LoginView loginView;

    public LoginPresenterImplementer(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onCreate() {
        loginView.initViews();
    }
}
