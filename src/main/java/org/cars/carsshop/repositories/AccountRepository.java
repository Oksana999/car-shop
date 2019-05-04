package org.cars.carsshop.repositories;

import org.cars.carsshop.entities.Account;
import org.cars.carsshop.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {


//    Optional<Account> findAccountByUser_UserId (User account_user);


}
