package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;
import web.model.Car;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(Integer count, Model model) {
        List<Car> cars;
        if (count != null && count >= 1 && count < 5) {
            cars = carService.findCars(count);
        } else {
            cars = carService.findAllCars();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}


