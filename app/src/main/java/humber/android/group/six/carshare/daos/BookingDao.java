package humber.android.group.six.carshare.daos;

import androidx.room.Dao;
import androidx.room.Insert;

import humber.android.group.six.carshare.models.Booking;

@Dao
public interface BookingDao {
    @Insert
    void insertBooking(Booking booking);
}
