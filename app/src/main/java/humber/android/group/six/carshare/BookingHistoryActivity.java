package humber.android.group.six.carshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BookingHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);

        RecyclerView recyclerView = findViewById(R.id.rv_booking);

        Booking booking = new Booking();

        BookingHistoryAdapter bookingHistoryAdapter = new BookingHistoryAdapter(booking.createDummyBookings());

        recyclerView.setAdapter(bookingHistoryAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}