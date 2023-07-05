package com.spring.market.controller;
import com.spring.market.model.User;
import com.spring.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userUpdates) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            user.setName(userUpdates.getName());
            user.setEmail(userUpdates.getEmail());
            user.setTelephone(userUpdates.getTelephone());
            user.setCarts(userUpdates.getCarts());
            userRepository.save(user);
        }
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

