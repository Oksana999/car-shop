package org.cars.carsshop.repositories;

import org.cars.carsshop.entities.Car;
import org.cars.carsshop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    Optional<Car> findCarByCarId (int carId);
    List<Car> findCarsByModel(String model);
    List<Car> findCarsByType(String type);
}

