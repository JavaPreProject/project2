package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarService;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "car")
   public String printCarPage(@RequestParam(value = "count", defaultValue = "5") int count_of_car_list, Model model) {
       System.out.println("count_of_car_list :" + count_of_car_list);
       System.out.println();

       model.addAttribute("messages", "Список автомобилей");
       model.addAttribute("car_message", carService.getListCar(count_of_car_list));
       return "car/car";
   }
}
