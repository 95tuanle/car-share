package humber.android.group.six.carshare.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import humber.android.group.six.carshare.models.Booking;

@Dao
public interface BookingDao {
    @Insert
    void insertBooking(Booking booking);

    @Query("SELECT * FROM booking WHERE uid = :uid AND is_active = 1 ORDER BY bid DESC")
    List<Booking> getBookingsByUid(int uid);
}
