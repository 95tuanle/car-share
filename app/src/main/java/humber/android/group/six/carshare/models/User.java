package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @ColumnInfo(name = "email")
    public final String email;
    @ColumnInfo(name = "password")
    public final String password;
    @ColumnInfo(name = "is_standard")
    public final boolean isStandard;
    @PrimaryKey(autoGenerate = true)
    public int uid;

    public User(String email, String password, boolean isStandard) {
        this.email = email;
        this.password = password;
        this.isStandard = isStandard;
    }
}