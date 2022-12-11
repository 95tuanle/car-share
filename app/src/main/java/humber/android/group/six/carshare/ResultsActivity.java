package humber.android.group.six.carshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        RecyclerView recyclerView = findViewById(R.id.rv_car);

        ResultsAdapter resultsAdapter = new ResultsAdapter(new CarDummy().createDummyCars());

        recyclerView.setAdapter(resultsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}