package org.cars.carsshop.services;

import org.cars.carsshop.entities.User;
import org.cars.carsshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> createUser(String fName, String lName, String email, String password) {

        if (userRepository.findUserByEmail(email).isPresent()) {
            return Optional.empty();
        }

        String md5pass = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = new User(fName, lName, email, md5pass);
        userRepository.save(user);


        return Optional.of(user);
    }

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findUserByEmail(email);
        if (!userOpt.isPresent()) {
            return Optional.empty();
        }
        User user = userOpt.get();
        String md5pass = DigestUtils.md5DigestAsHex(password.getBytes());

        if (user.getPassword().equals(md5pass)) {
            return Optional.of(user);
        } else

            return Optional.empty();
    }
}
