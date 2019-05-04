package org.cars.carsshop.services;

import org.cars.carsshop.entities.Replenishment;
import org.cars.carsshop.entities.Transaction;
import org.cars.carsshop.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TransactionService {
    public void saveReplenishment (Replenishment replenishment);
    List<Transaction> getAllTransactions (User user);
}
