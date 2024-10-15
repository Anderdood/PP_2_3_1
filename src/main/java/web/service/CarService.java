package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList;

    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2020));
        carList.add(new Car("Honda", "Accord", 2019));
        carList.add(new Car("Ford", "Mustang", 2021));
        carList.add(new Car("Chevrolet", "Malibu", 2018));
        carList.add(new Car("Nissan", "Altima", 2022));
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public List<Car> getCars(int count) {
        return carList.subList(0, Math.min(count, carList.size()));
    }
}
