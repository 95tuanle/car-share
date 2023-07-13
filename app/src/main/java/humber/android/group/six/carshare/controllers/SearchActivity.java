package humber.android.group.six.carshare.controllers;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import humber.android.group.six.carshare.Converters;
import humber.android.group.six.carshare.DatePickerFragment;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.TimePickerFragment;

public class SearchActivity extends AppCompatActivity {

    private String address;
    private DatePickerFragment pickupDateDatePickerFragment;
    private DatePickerFragment dropOffDatePickerFragment;
    private TimePickerFragment pickupTimeDialogFragment;
    private TimePickerFragment dropOffTimeDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (!Places.isInitialized()) {
            Places.initialize(this, "AIzaSyAj2raHGkv1SjE1WH4mcRIfkjnbvrz04Kk", Locale.CANADA);
        }

        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.f_pickup_location);
        assert autocompleteFragment != null;
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.NAME, Place.Field.ADDRESS));
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                address = place.getAddress();
            }

            @Override
            public void onError(@NonNull Status status) {
                Log.i(TAG, "An error occurred: " + status);
                Toast.makeText(SearchActivity.this, "An error occurred: " + status, Toast.LENGTH_SHORT).show();
                address = status.toString();
            }
        });

        pickupTimeDialogFragment = new TimePickerFragment(findViewById(R.id.b_pickup_time));
        dropOffTimeDialogFragment = new TimePickerFragment(findViewById(R.id.b_drop_off_time));
        pickupDateDatePickerFragment = new DatePickerFragment(findViewById(R.id.b_pickup_date));
        dropOffDatePickerFragment = new DatePickerFragment(findViewById(R.id.b_drop_off_date));
    }

    public void pickupTime(View view) {
        pickupTimeDialogFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void dropOffTime(View view) {
        dropOffTimeDialogFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void pickupDate(View view) {
        pickupDateDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void dropOffDate(View view) {
        dropOffDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public void search(View view) {
        if (address == null) {
            Toast.makeText(this, "Address must not be blank", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("pickup", Converters.dateToTimestamp(getDate(pickupDateDatePickerFragment.getYear(), pickupDateDatePickerFragment.getMonth(), pickupDateDatePickerFragment.getDay(), pickupTimeDialogFragment.getHour(), pickupTimeDialogFragment.getMinute())));
            intent.putExtra("dropOff", Converters.dateToTimestamp(getDate(dropOffDatePickerFragment.getYear(), dropOffDatePickerFragment.getMonth(), dropOffDatePickerFragment.getDay(), dropOffTimeDialogFragment.getHour(), dropOffTimeDialogFragment.getMinute())));
            this.startActivity(intent);
        }
    }

    public Date getDate(int year, int month, int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);
        return calendar.getTime();
    }
}
