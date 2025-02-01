package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        logger.info("Добавление пользователя:{}", user);
        userDao.saveUser(user);
    }

    public User findUserById(Integer id) {
        return userDao.getUser(id);
    }

    public boolean checkUserAge(Integer id) throws IllegalArgumentException {
        var userAge = userDao.getUserAge(id);
        if (userAge == null) {
            throw new IllegalArgumentException();
        }
        return userAge >= 18;
    }
}
