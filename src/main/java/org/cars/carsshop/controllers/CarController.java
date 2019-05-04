package org.cars.carsshop.controllers;

import org.cars.carsshop.entities.Account;
import org.cars.carsshop.entities.User;
import org.cars.carsshop.services.AccountService;
import org.cars.carsshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
    @GetMapping ("/home")
    public String home (){
        return "hello";
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


//    @PostMapping(value = "/logout")
//    public ModelAndView logoutUser(HttpSession session, @ModelAttribute("user") User user) {
//        session.invalidate();
//        return new ModelAndView("home", "user", new User());
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "hello";
    }

    @PostMapping("/checkRegistration")
    public String checkRegistration(Model model,
                                    @RequestParam String fName,
                                    @RequestParam String lName,
                                    @RequestParam String email,
                                    @RequestParam String password) {
        Optional<User> user = userService.createUser(fName, lName, email, password);

        if (user.isPresent()) {
            return "successRegistration";
        } else {
            model.addAttribute("message", "User already exists or " +
                    "email not valid");
            return "error";
        }
    }

    @PostMapping("/checkLogin")
    public String checkLogin(Model model,
                             HttpSession session,
                             @RequestParam String email,
                             @RequestParam String password) {
        Optional<User> user = userService.login(email, password);

        if (user.isPresent()) {
            session.setAttribute("currentUser", user.get());
//            model.addAttribute("user", user.get());
            return "hello";
        }else {
            model.addAttribute("message", "User already exists or " +
                    "email not valid");
            return "error";

    }
}

    @PostMapping("/createAccount")
    public String createAccount(Model model,
                                HttpSession session,
                                @RequestParam String userId) {
        Optional<Account> account = accountService.createAccount(userId);
        if (account.isPresent()){
            session.setAttribute("account", account.get());
            return "hello";
        }
        return "";
    }

    @PostMapping("/replenishment")
    @ResponseBody
    public String replenishment (@RequestParam String userId,
                                 @RequestParam String amount){

            Optional<Account> account = accountService.replenishment(userId, amount);
            if(!account.isPresent()){
                return "Account not found";
            }
            return "OK";
    }



}
