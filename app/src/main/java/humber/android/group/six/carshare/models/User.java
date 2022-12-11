package humber.android.group.six.carshare.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "is_standard")
    public boolean isStandard;

    public User(@NonNull String email, String password, boolean isStandard) {
        this.email = email;
        this.password = password;
        this.isStandard = isStandard;
    }
}