package org.cars.carsshop.services;

import org.cars.carsshop.entities.Account;
import org.cars.carsshop.entities.Replenishment;
import org.cars.carsshop.entities.User;
import org.cars.carsshop.repositories.AccountRepository;
import org.cars.carsshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionService transactionService;

    @Override
    public Optional<Account> createAccount(String userId) {

        Optional<User> user = userRepository.findById(Integer.valueOf(userId));
        Optional<Account> accountOpt = accountRepository.findById(Integer.valueOf(userId));
        if(!user.isPresent()|| accountOpt.isPresent()){
            return Optional.empty();
        }else {
            Account account = new Account();
            account.setUser(user.get());
            accountRepository.save(account);
            return Optional.of(account);
        }

    }


    @Override
    public Optional<Account> replenishment(String userId, String amount) {

        Optional<Account> accountOptional = accountRepository.findById(Integer.valueOf(userId));

//        Optional<Account> accountOpt = accountRepository.findById(Integer.valueOf(id) );
        if(!accountOptional.isPresent()){
            return Optional.empty();
        }
        Account account = accountOptional.get();
        account.setAmount(account.getAmount()+ Double.valueOf(amount));
        accountRepository.save(account);
        Replenishment replenishment = new Replenishment();
        replenishment.setAccount(account);
        replenishment.setDateTime(LocalDateTime.now());
        replenishment.setValue(Double.valueOf(amount));
        transactionService.saveReplenishment(replenishment);
        return accountOptional;


    }

}
