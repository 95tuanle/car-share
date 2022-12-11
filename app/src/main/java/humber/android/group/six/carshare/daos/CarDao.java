package humber.android.group.six.carshare.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import humber.android.group.six.carshare.models.Car;


@Dao
public interface CarDao {
    @Query("SELECT COUNT(*) FROM car")
    int countCar();

    @Insert()
    void insertCar(Car car);
}
