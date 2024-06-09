package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private final List<Car> cars = Arrays.asList(
            new Car("Audi", "white", 1_200_000),
            new Car("Kia", "blue", 900_000),
            new Car("Opel", "red", 1_000_000),
            new Car("Lexus", "green", 5_000_000),
            new Car("Toyota", "yellow", 2_000_000)
    );

    @Override
    public List<Car> findCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }

    @Override
    public List<Car> findAllCars() {
        return cars;
    }
}
