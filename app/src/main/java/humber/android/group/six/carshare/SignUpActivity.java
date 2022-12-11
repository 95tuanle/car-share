package humber.android.group.six.carshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        confirmPasswordEditText = findViewById(R.id.et_confirm_password);
    }

    public void signUp(View view) {
        String email = emailEditText.getText().toString().toLowerCase(Locale.ROOT);
        String password = passwordEditText.getText().toString();
        String confirmedPassword = confirmPasswordEditText.getText().toString();
        if (email.isBlank() || password.isBlank() || confirmedPassword.isBlank()) {
            Common.makeToast(getApplicationContext(), "Email and passwords must not be blank", Toast.LENGTH_SHORT);
        } else if (!password.equals(confirmedPassword)) {
            Common.makeToast(getApplicationContext(), "Password and confirm password are not matching", Toast.LENGTH_SHORT);
        } else {
            UserDao userDao = AppDatabase.getInstance(this).userDao();
            if (userDao.checkEmail(email) != 0) {
                Common.makeToast(getApplicationContext(), "Unable to sign up with that email", Toast.LENGTH_SHORT);
            } else {
                userDao.insertUser(new User(email, password, false));
                this.startActivity(new Intent(this, LoginActivity.class));
            }
        }
    }


}