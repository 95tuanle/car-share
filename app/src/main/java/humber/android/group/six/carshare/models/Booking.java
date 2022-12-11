package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Booking {
    @PrimaryKey(autoGenerate = true)
    public int bid;

    @ColumnInfo(name = "drop_off_date")
    public Date dropOffDate;

    public int cid;
    public int uid;

    public Booking(Date dropOffDate, int cid, int uid) {
        this.dropOffDate = dropOffDate;
        this.cid = cid;
        this.uid = uid;
    }
}
