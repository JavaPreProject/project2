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
        for (int i = 1; i < 6; i ++ ) {
            listCar.add(new Car("ВАЗ 210" + i, String.valueOf((int)(Math.random()*1_000_000)), i+20));
        }
        return listCar;
    }
}
