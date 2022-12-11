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
import java.util.Locale;

import humber.android.group.six.carshare.Common;
import humber.android.group.six.carshare.Converters;
import humber.android.group.six.carshare.DatePickerFragment;
import humber.android.group.six.carshare.R;

public class SearchActivity extends AppCompatActivity {

    private String address;
    private DatePickerFragment pickupDateDatePickerFragment;
    private DatePickerFragment dropOffDatePickerFragment;
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
            }
        });

        pickupDateDatePickerFragment = new DatePickerFragment(findViewById(R.id.b_pickup_date));
        dropOffDatePickerFragment = new DatePickerFragment(findViewById(R.id.b_drop_off_date));
    }

    public void pickupDate(View view) {
        pickupDateDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void dropOffDate(View view) {
        dropOffDatePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public void search(View view) {
        if (address == null) {
            Common.makeToast(this, "Address must not be blank", Toast.LENGTH_SHORT);
        } else {
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("pickup", Converters.dateToTimestamp(pickupDateDatePickerFragment.getDate()));
            intent.putExtra("dropOff", Converters.dateToTimestamp(dropOffDatePickerFragment.getDate()));
            this.startActivity(intent);
        }
    }
}
