package org.cars.carsshop.services;

import org.cars.carsshop.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> createUser (String fName, String lName, String email, String password);

    Optional<User>login(String email, String password);


}
