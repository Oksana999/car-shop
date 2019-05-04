package org.cars.carsshop.services;

import org.cars.carsshop.entities.Account;
import org.cars.carsshop.entities.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Optional<Account> createAccount( String userId);

    public Optional<Account> replenishment(String userId, String amount);

}

