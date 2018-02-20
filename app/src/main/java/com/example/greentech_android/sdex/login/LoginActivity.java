package com.example.greentech_android.sdex.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.greentech_android.sdex.R;
import com.example.greentech_android.sdex.tabs.TabsActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by GreenTech-Android on 2/19/2018.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton loginButton;
    LoginPresenterImplementer loginPresenterImplementer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenterImplementer = new LoginPresenterImplementer(this);
        loginPresenterImplementer.onCreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initViews() {
        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button);
        if (AccessToken.getCurrentAccessToken() != null) {
            Intent intent = new Intent(LoginActivity.this, TabsActivity.class);
            startActivity(intent);
            finish();
        } else {
            loginButton.setReadPermissions(Arrays.asList(EMAIL, "user_friends"));
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                    Intent intent = new Intent(LoginActivity.this, TabsActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onCancel() {
                    // App code
                    Toast.makeText(getApplicationContext(), "Login canceled", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                    Toast.makeText(getApplicationContext(), exception.toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
