package humber.android.group.six.carshare.controllers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import humber.android.group.six.carshare.CarDummy;
import humber.android.group.six.carshare.R;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private final List<CarDummy> carDummies;

    public ResultsAdapter(List<CarDummy> carDummies) {
        this.carDummies = carDummies;
    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(carDummies.get(position).getSummary());
        ImageView imageView = holder.getImageView();
        Context context = imageView.getContext();
        imageView.setImageResource(context.getResources().getIdentifier(carDummies.get(position).getImage(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return carDummies.size();
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
