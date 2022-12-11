package humber.android.group.six.carshare.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {
    @PrimaryKey(autoGenerate = true)
    public int cid;
}
