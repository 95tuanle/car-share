package humber.android.group.six.carshare.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import humber.android.group.six.carshare.R;

public class LoginSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
    }

    public void login(View view) {
        this.startActivity(new Intent(this, LoginActivity.class));
    }

    public void signUp(View view) {
        this.startActivity(new Intent(this, SignUpActivity.class));
    }
}