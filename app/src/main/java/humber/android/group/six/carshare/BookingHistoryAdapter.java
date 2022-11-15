package humber.android.group.six.carshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookingHistoryAdapter extends RecyclerView.Adapter<BookingHistoryAdapter.ViewHolder>{
    private final List<Booking> bookings;

    @NonNull
    @Override
    public BookingHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingHistoryAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(bookings.get(position).getSummary());
        ImageView imageView = holder.getImageView();
        Context context = imageView.getContext();
        imageView.setImageResource(context.getResources().getIdentifier(bookings.get(position).getImage(), "drawable", context.getPackageName()));
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

    public BookingHistoryAdapter(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
