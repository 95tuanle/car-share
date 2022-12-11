package humber.android.group.six.carshare;

import java.util.ArrayList;
import java.util.List;

public class CarDummy {
    String summary;
    String image;

    public CarDummy(String summary, String image) {
        this.summary = summary;
        this.image = image;
    }

    public CarDummy() {
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

    public List<CarDummy> createDummyCars() {
        List<CarDummy> carDummies = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            carDummies.add(new CarDummy("CarDummy Summary " + i, "@drawable/ic_launcher_foreground"));
        }
        return carDummies;
    }
}