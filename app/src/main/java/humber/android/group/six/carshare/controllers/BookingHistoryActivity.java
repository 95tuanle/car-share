package humber.android.group.six.carshare.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import humber.android.group.six.carshare.BookingDummy;
import humber.android.group.six.carshare.controllers.adapters.BookingHistoryAdapter;
import humber.android.group.six.carshare.R;

public class BookingHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);

        RecyclerView recyclerView = findViewById(R.id.rv_booking);

        BookingHistoryAdapter bookingHistoryAdapter = new BookingHistoryAdapter(new BookingDummy().createDummyBookings());

        recyclerView.setAdapter(bookingHistoryAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}