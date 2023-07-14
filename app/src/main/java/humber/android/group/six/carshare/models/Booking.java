package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Booking {
    @ColumnInfo(name = "pickup_date")
    public final Date pickupDate;
    @ColumnInfo(name = "drop_off_date")
    public final Date dropOffDate;
    @ColumnInfo(name = "cid")
    public final int cid;
    @ColumnInfo(name = "uid")
    public final int uid;
    @ColumnInfo(name = "is_active")
    public final boolean isActive;
    @ColumnInfo(name = "address")
    public final String address;
    @PrimaryKey(autoGenerate = true)
    public int bid;

    public Booking(Date pickupDate, Date dropOffDate, int cid, int uid, boolean isActive, String address) {
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.cid = cid;
        this.uid = uid;
        this.isActive = isActive;
        this.address = address;
    }
}
