package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user/")
@RestController
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/check-age/{userId}")
    public Boolean checkUserAge(@PathVariable Integer userId) {
        return userService.checkUserAge(userId);
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(value = "/get/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.findUserById(userId);
    }
}
