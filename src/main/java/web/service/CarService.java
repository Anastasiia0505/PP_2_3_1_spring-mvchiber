package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars(int count);//метод для получения списка машин

    List<Car> findAllCars();
}