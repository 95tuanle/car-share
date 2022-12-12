package humber.android.group.six.carshare.controllers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import humber.android.group.six.carshare.AppDatabase;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.controllers.adapters.ResultsAdapter;
import humber.android.group.six.carshare.daos.CarDao;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String address = getIntent().getStringExtra("address");
        long pickup = getIntent().getLongExtra("pickup", 0);
        long dropOff = getIntent().getLongExtra("dropOff", 0);

        RecyclerView recyclerView = findViewById(R.id.rv_car);

        CarDao carDao = AppDatabase.getInstance(this).carDao();
        ResultsAdapter resultsAdapter = new ResultsAdapter(carDao.findAvailableCars(), address, pickup, dropOff, this);

        recyclerView.setAdapter(resultsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}