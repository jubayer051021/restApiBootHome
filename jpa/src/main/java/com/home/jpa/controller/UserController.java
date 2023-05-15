package com.home.jpa.controller;

import com.home.jpa.model.User;
import com.home.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers(ModelAndView model) {
        return userService.getAllUsers();
    }
    @GetMapping("/detail/{id}")
    public Optional<User> getUser(@PathVariable long id, ModelAndView model) {
        return userService.getUser(id);
    }
    @PostMapping("/add")
    public User addUser(@ModelAttribute User user, ModelAndView model) {
         userService.addUser(user);
         return user;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id, ModelAndView model) {
        userService.deleteUser(id);
        return;
    }
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable long id,@ModelAttribute User updateUser, ModelAndView model){
        userService.updateUser(id,updateUser);
    }

}
