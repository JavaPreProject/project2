package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model;
    private String series;
    private int age;

    public Car(String name, String series, int age) {
        this.model = name;
        this.series = series;
        this.age = age;
    }

    public Car() {
    }

    public int getAge() {
        return age;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }
}
