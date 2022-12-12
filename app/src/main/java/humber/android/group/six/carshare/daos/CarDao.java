package humber.android.group.six.carshare.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import humber.android.group.six.carshare.models.Car;

@Dao
public interface CarDao {
    @Query("SELECT COUNT(*) FROM car")
    int countCar();

    @Insert()
    void insertCar(Car car);

    @Query("SELECT * FROM car WHERE is_available = 1")
    List<Car> findAvailableCars();

    @Query("SELECT * FROM car WHERE cid = :cid")
    Car getCarByCid(int cid);

    @Update()
    void updateCar(Car car);
}
