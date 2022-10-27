package humber.android.group.six.carshare;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String summary;
    String image;

    public Car(String summary, String image) {
        this.summary = summary;
        this.image = image;
    }

    public Car() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Car> createDummyCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            cars.add(new Car("Car Summary " + i, "@drawable/ic_launcher_foreground"));
        }
        return cars;
    }
}