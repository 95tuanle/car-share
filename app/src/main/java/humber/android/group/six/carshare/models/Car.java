package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Car {
    @ColumnInfo(name = "manufacturer")
    public final String manufacturer;
    @ColumnInfo(name = "model")
    public final String model;
    @ColumnInfo(name = "location")
    public final String location;
    @ColumnInfo(name = "owner")
    public final int uid;
    @ColumnInfo(name = "available_form")
    public final Date availableForm;
    @ColumnInfo(name = "daily_rate")
    public final Double dailyRate;
    @ColumnInfo(name = "rating")
    public final Double rating;
    @ColumnInfo(name = "description")
    public final String description;
    @ColumnInfo(name = "image")
    public final String image;
    @PrimaryKey(autoGenerate = true)
    public int cid;
    @ColumnInfo(name = "is_available")
    public boolean isAvailable;

    public Car(String manufacturer, String model, String location, int uid, Date availableForm, Double dailyRate, Double rating, String description, String image, boolean isAvailable) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.location = location;
        this.uid = uid;
        this.availableForm = availableForm;
        this.dailyRate = dailyRate;
        this.rating = rating;
        this.description = description;
        this.image = image;
        this.isAvailable = isAvailable;
    }
}
