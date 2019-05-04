package org.cars.carsshop.services;

import org.cars.carsshop.entities.Replenishment;
import org.cars.carsshop.entities.Transaction;
import org.cars.carsshop.entities.User;
import org.cars.carsshop.repositories.ReplenishmenrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ReplenishmenrRepository replenishmenrRepository;
    @Override
    public void saveReplenishment(Replenishment replenishment) {

    }

    @Override
    public List<Transaction> getAllTransactions(User user) {

        List<Transaction> transactions = new ArrayList<>();
//        transactions.addAll(replenishmenrRepository.findById(Integer.valueOf(userId));


        return null;
    }
}
