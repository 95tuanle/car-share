package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Booking {
    @PrimaryKey(autoGenerate = true)
    public int bid;

    @ColumnInfo(name = "pickup_date")
    public Date pickupDate;

    @ColumnInfo(name = "drop_off_date")
    public Date dropOffDate;

    @ColumnInfo(name = "cid")
    public int cid;

    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "is_active")
    public boolean isActive;

    @ColumnInfo(name = "address")
    public String address;

    public Booking(Date pickupDate, Date dropOffDate, int cid, int uid, boolean isActive, String address) {
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.cid = cid;
        this.uid = uid;
        this.isActive = isActive;
        this.address = address;
    }
}
