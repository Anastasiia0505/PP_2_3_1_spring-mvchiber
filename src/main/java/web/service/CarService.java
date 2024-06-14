package web.service;

import web.model.User;
import java.util.List;

public interface CarService {
    List<User> findCars(int count);
    List<User> findAllCars();
}
