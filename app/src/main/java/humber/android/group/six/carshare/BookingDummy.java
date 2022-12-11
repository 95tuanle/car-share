package humber.android.group.six.carshare;

import java.util.ArrayList;
import java.util.List;

public class BookingDummy {
    String summary;
    String image;

    public BookingDummy(String summary, String image) {
        this.summary = summary;
        this.image = image;
    }

    public BookingDummy() {
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

    public List<BookingDummy> createDummyBookings() {
        List<BookingDummy> bookingDummies = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            bookingDummies.add(new BookingDummy("BookingDummy Summary " + i, "@drawable/ic_launcher_foreground"));
        }
        return bookingDummies;
    }
}
