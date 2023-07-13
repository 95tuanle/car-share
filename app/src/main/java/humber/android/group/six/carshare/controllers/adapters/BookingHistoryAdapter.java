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
import humber.android.group.six.carshare.controllers.BookingConfirmationActivity;
import humber.android.group.six.carshare.controllers.BookingHistoryActivity;
import humber.android.group.six.carshare.daos.CarDao;
import humber.android.group.six.carshare.models.Booking;
import humber.android.group.six.carshare.models.Car;

public class BookingHistoryAdapter extends RecyclerView.Adapter<BookingHistoryAdapter.ViewHolder> {
    private final List<Booking> bookings;
    private final CarDao carDao;
    private final BookingHistoryActivity bookingHistoryActivity;

    public BookingHistoryAdapter(List<Booking> bookings, CarDao carDao, BookingHistoryActivity bookingHistoryActivity) {
        this.bookings = bookings;
        this.carDao = carDao;
        this.bookingHistoryActivity = bookingHistoryActivity;
    }

    @NonNull
    @Override
    public BookingHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingHistoryAdapter.ViewHolder holder, int position) {
        Car car = carDao.getCarByCid(bookings.get(position).cid);
        holder.getTextView().setText(String.format("%s %s\nPickup date:\n %s\nDrop-off\n date %s", car.manufacturer, car.model, bookings.get(position).pickupDate, bookings.get(position).dropOffDate));
        new DownloadImageTask(holder.getImageView()).execute(car.image);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(bookingHistoryActivity, BookingConfirmationActivity.class);
            intent.putExtra("address", bookings.get(position).address);
            intent.putExtra("pickup", Converters.dateToTimestamp(bookings.get(position).pickupDate));
            intent.putExtra("dropOff", Converters.dateToTimestamp(bookings.get(position).dropOffDate));
            intent.putExtra("cid", bookings.get(position).cid);
            bookingHistoryActivity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_booking);
            imageView = itemView.findViewById(R.id.iv_booking);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
