package humber.android.group.six.carshare.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Booking {
    @PrimaryKey(autoGenerate = true)
    public int bid;
}
