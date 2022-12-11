package humber.android.group.six.carshare.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Car {
    @PrimaryKey(autoGenerate = true)
    public int cid;

    @ColumnInfo(name = "manufacturer")
    public String manufacturer;

    @ColumnInfo(name = "model")
    public String model;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "owner")
    public int uid;

    @ColumnInfo(name = "available_form")
    public Date availableForm;

    @ColumnInfo(name = "daily_rate")
    public Double dailyRate;

    @ColumnInfo(name = "rating")
    public Double rating;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "image")
    public String image;

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
