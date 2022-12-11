package humber.android.group.six.carshare;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import humber.android.group.six.carshare.daos.BookingDao;
import humber.android.group.six.carshare.daos.CarDao;
import humber.android.group.six.carshare.daos.UserDao;
import humber.android.group.six.carshare.models.Booking;
import humber.android.group.six.carshare.models.Car;
import humber.android.group.six.carshare.models.Converters;
import humber.android.group.six.carshare.models.User;

@Database(entities = {User.class, Car.class, Booking.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "humber.android.group.six.carshare").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return appDatabase;
    }
    public abstract UserDao userDao();
    public abstract CarDao carDao();
    public abstract BookingDao bookingDao();
}