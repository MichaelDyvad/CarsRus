package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getCars(){
        List<Car> cars = carRepository.findAll();
        return CarResponse.getCarsFromEntities(cars);
    }

    public CarResponse getCar(int id,boolean all) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Client4xxException("no car with this id exist"));
        return new CarResponse(car, false);
    }

    public CarResponse addCar(CarRequest body){
        Car carnew = carRepository.save(new Car (body));
        return new CarResponse(carnew, false);
    }

    public void editCar( CarRequest carToEdit, int carId){
        Car car = carRepository.findById(carId).orElseThrow(()-> new Client4xxException("No car with provided ID found"));
        car.setBrand(carToEdit.getCarBrand());
        car.setModel(carToEdit.getModel());
        car.setPricePrDay(carToEdit.getPricePrDay());
        carRepository.save(car);
    }

    //Service method for PATCH
    public void updatePrice(int carId,double newPricePrDay){
        Car car = carRepository.getById(carId);
        car.setPricePrDay(newPricePrDay);
        carRepository.save(car);
    }

}

