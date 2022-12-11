package humber.android.group.six.carshare.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import humber.android.group.six.carshare.models.User;

@Dao
public interface UserDao {
    @Insert()
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Query("SELECT COUNT(*) FROM user WHERE email = :email")
    int checkEmail(String email);
}