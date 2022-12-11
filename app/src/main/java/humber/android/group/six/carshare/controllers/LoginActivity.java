package humber.android.group.six.carshare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import humber.android.group.six.carshare.AppDatabase;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.daos.UserDao;
import humber.android.group.six.carshare.models.User;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
    }

    public void login(View view) {
        String email = emailEditText.getText().toString().toLowerCase(Locale.ROOT);
        String password = passwordEditText.getText().toString();
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(getApplicationContext(), "Email and passwords must not be blank", Toast.LENGTH_LONG).show();
        } else {
            UserDao userDao = AppDatabase.getInstance(this).userDao();
            User user = userDao.getUserByEmail(email);
            if (user == null) {
                Toast.makeText(getApplicationContext(), "Wrong email", Toast.LENGTH_LONG).show();
            } else {
                if (!user.password.equals(password)) {
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("humber.android.group.six.carshare", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.putString("email", email);
                    editor.apply();
                    this.startActivity(new Intent(this, BookingHistoryActivity.class));
                }
            }
        }
    }
}