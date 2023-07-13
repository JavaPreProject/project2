package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class daoCarImpl implements DaoCar {
    private final List<Car> listCar= new ArrayList<>(6);
    @Override
    public List<Car> getListCar() {
        for (int i = 0; i < 5; i ++ ) {
            listCar.add(new Car("nameCar" + i, "seriesCar" + i, i));
        }
        return listCar;
    }
}
