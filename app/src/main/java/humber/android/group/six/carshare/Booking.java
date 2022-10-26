package humber.android.group.six.carshare;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    String summary;
    String image;

    public Booking(String summary, String image) {
        this.summary = summary;
        this.image = image;
    }

    public Booking() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<Booking> createDummyBookings() {
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            bookings.add(new Booking("Booking Summary " + i, "@drawable/ic_launcher_foreground"));
        }
        return bookings;
    }
}
