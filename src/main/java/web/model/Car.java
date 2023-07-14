package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model;
    private String series;
    private String age;

    public Car(String name, String series, String age) {
        this.model = name;
        this.series = series;
        this.age = age;
    }

    public Car() {
    }

    public String getAge() {
        return age;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }
}
