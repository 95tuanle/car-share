package humber.android.group.six.carshare.controllers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import humber.android.group.six.carshare.AppDatabase;
import humber.android.group.six.carshare.Converters;
import humber.android.group.six.carshare.DownloadImageTask;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.daos.CarDao;
import humber.android.group.six.carshare.models.Booking;
import humber.android.group.six.carshare.models.Car;

public class BookingOverviewActivity extends AppCompatActivity {

    private String address;
    private long pickup;
    private long dropOff;
    private int cid;
    private AppDatabase appDatabase;
    private CarDao carDao;
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_overview);

        address = getIntent().getStringExtra("address");
        pickup = getIntent().getLongExtra("pickup", 0);
        dropOff = getIntent().getLongExtra("dropOff", 0);
        cid = getIntent().getIntExtra("cid", 0);

        appDatabase = AppDatabase.getInstance(this);
        carDao = appDatabase.carDao();
        car = carDao.getCarByCid(cid);

        TextView textView = findViewById(R.id.tv_booking_detail);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(String.format("Car model: %s %s\nPickup address: %s\nYour address: %s\nDaily rate: $%s\nRating: %s\nDescription: %s\nPickup date: %s\nDrop-off date: %s", car.manufacturer, car.model, car.location, address, car.dailyRate, car.rating, car.description, Converters.fromTimestamp(pickup), Converters.fromTimestamp(dropOff)));
        ImageView imageView = findViewById(R.id.iv_car);
        new DownloadImageTask(imageView).execute(car.image);
    }

    public void confirm(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("humber.android.group.six.carshare", MODE_PRIVATE);
        appDatabase.bookingDao().insertBooking(new Booking(Converters.fromTimestamp(pickup), Converters.fromTimestamp(dropOff), cid, sharedPreferences.getInt("uid", -1), true, address));
        car.isAvailable = false;
        carDao.updateCar(car);
        Toast.makeText(this, "Booking confirmed", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, BookingConfirmationActivity.class);
        intent.putExtra("address", address);
        intent.putExtra("pickup", pickup);
        intent.putExtra("dropOff", dropOff);
        intent.putExtra("cid", cid);
        this.startActivity(intent);
    }
}