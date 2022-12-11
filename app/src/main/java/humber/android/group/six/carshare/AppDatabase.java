package humber.android.group.six.carshare;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Car.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "humber.android.group.six.carshare").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return appDatabase;
    }
    public abstract UserDao userDao();
}