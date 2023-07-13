package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.DaoCar;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    DaoCar daoCar;

    @Override
    public List<Car> getListCar(int count) {

        if (count > 5) {
            count = 5;
        }

        List<Car> collect = new ArrayList<>();
        int limit = 0;
        for (Car car : daoCar.getListCar()) {
            if (limit++ == count) break;
            collect.add(car);
        }
        return collect;
    }
}
