package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    //@Autowired
    //DaoCar daoCar;

    List<Car>listCar = Arrays.asList(
            new Car("Kenworth W900", "W900", "since 1961" ),
            new Car("IVECO Trakker", "AD380T 38H", "2007"),
            new Car("Paccar MX-11", "MX-11", "2019"),
            new Car("Ford Mustang Mach-E", " First Edition" , "2020"),
            new Car("Holden Caprice", "VR", "1994")
    );

    @Override
    public List<Car> getListCar(int count) {

        if (count > listCar.size() || count < 0) {
            return listCar;
        }

        return listCar.stream().limit(count).collect(Collectors.toList());
    }
}
