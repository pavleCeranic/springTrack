package dev.pavleceranic.jdbc_users.controller;

import dev.pavleceranic.jdbc_users.model.User;
import dev.pavleceranic.jdbc_users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println("whatsgoingon");
        System.out.println(user.getPassword());
        System.out.println("whatsgoingon");


//
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return usersRepository.save(user);
    }

}
