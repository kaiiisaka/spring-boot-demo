package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user/")
@RestController
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/check-age/{userId}")
    public Boolean checkUserAge(@PathVariable Long userId) {
        return userService.checkUserAge(userId);
    }
}
