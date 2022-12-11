package humber.android.group.six.carshare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("humber.android.group.six.carshare", MODE_PRIVATE);
        Intent intent;
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            intent = new Intent(this, BookingHistoryActivity.class);
        } else {
            intent = new Intent(this, LoginSignUpActivity.class);
        }
        this.startActivity(intent);
    }
}