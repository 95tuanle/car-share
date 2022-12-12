package humber.android.group.six.carshare.controllers.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import humber.android.group.six.carshare.Converters;
import humber.android.group.six.carshare.DownloadImageTask;
import humber.android.group.six.carshare.R;
import humber.android.group.six.carshare.controllers.BookingOverviewActivity;
import humber.android.group.six.carshare.controllers.ResultsActivity;
import humber.android.group.six.carshare.models.Car;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {

    private final List<Car> cars;
    private final String address;
    private final long pickup;
    private final long dropOff;
    private final ResultsActivity resultsActivity;


    public ResultsAdapter(List<Car> cars, String address, long pickup, long dropOff, ResultsActivity resultsActivity) {
        this.cars = cars;
        this.address = address;
        this.pickup = pickup;
        this.dropOff = dropOff;
        this.resultsActivity = resultsActivity;
    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(String.format("%s %s\nDaily rate: $%s\n%s", cars.get(position).manufacturer, cars.get(position).model, cars.get(position).dailyRate, cars.get(position).availableForm.toString()));
        new DownloadImageTask(holder.getImageView()).execute(cars.get(position).image);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(resultsActivity, BookingOverviewActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("pickup", pickup);
            intent.putExtra("dropOff", dropOff);
            intent.putExtra("cid", cars.get(holder.getAdapterPosition()).cid);
            resultsActivity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_car);
            imageView = itemView.findViewById(R.id.iv_car);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
