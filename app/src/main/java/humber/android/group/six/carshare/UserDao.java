package humber.android.group.six.carshare;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert()
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Query("SELECT COUNT(*) FROM user WHERE email = :email")
    int checkEmail(String email);
}