package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
    public Integer getUserAge(long userId) {
        return (int) userId;
    }
}
