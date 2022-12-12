package humber.android.group.six.carshare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import humber.android.group.six.carshare.AppDatabase;
import humber.android.group.six.carshare.Converters;
import humber.android.group.six.carshare.DownloadImageTask;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.daos.CarDao;
import humber.android.group.six.carshare.models.Car;

public class BookingConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        String address = getIntent().getStringExtra("address");
        long pickup = getIntent().getLongExtra("pickup", 0);
        long dropOff = getIntent().getLongExtra("dropOff", 0);
        int cid = getIntent().getIntExtra("cid", 0);

        Car car = AppDatabase.getInstance(this).carDao().getCarByCid(cid);

        TextView textView = findViewById(R.id.tv_confirmed_booking_detail);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(String.format("Car model: %s %s\nLocation: %s\nAddress: %s\nDaily rate: $%s\nRating: %s\nDescription: %s\nPickup date: %s\nDrop-off date: %s", car.manufacturer, car.model, car.location, address, car.dailyRate, car.rating, car.description, Converters.fromTimestamp(pickup), Converters.fromTimestamp(dropOff)));
        ImageView imageView = findViewById(R.id.iv_car);
        new DownloadImageTask(imageView).execute(car.image);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.startActivity(new Intent(this, BookingHistoryActivity.class));
    }

    public void bookingHistory(View view) {
        this.startActivity(new Intent(this, BookingHistoryActivity.class));
    }
}