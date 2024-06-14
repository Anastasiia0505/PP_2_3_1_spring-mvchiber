package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private final List<User> cars = Arrays.asList(
            new User("Audi", "white", 1_200_000),
            new User("Kia", "blue", 900_000),
            new User("Opel", "red", 1_000_000),
            new User("Lexus", "green", 5_000_000),
            new User("Toyota", "yellow", 2_000_000)
    );

    @Override
    public List<User> findCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }

    @Override
    public List<User> findAllCars() {
        return cars;
    }
}
