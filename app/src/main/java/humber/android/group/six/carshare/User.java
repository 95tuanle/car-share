package humber.android.group.six.carshare;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class User {
    @PrimaryKey
    @NotNull
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