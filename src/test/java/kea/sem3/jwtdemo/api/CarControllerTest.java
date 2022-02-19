package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarControllerTest {
    @Autowired
    CarService carService;

    CarRepository carRepository;

    static int car1Id;
    static int car2Id;

    @BeforeEach
    void setUp() {
        car1Id = carRepository.save(new Car("Volvo", "C40", 560)).getId();
        car2Id = carRepository.save(new Car("WW", "Up", 300)).getId();

    }

    @Test
    void getCars() {
        List<CarResponse> carList = carService.getCars();

    }

    @Test
    void addCar() {
    }
}