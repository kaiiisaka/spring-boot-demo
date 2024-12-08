package com.example.demo.service;

import com.example.demo.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserAge(long id) throws IllegalArgumentException {
        var userAge = userDao.getUserAge(id);
        if (userAge == null) {
            throw new IllegalArgumentException();
        }
        return userAge >= 18;
    }
}
