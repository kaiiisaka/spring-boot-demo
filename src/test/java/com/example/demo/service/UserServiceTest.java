package com.example.demo.service;


import com.example.demo.dao.UserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserDao userDao;

    @InjectMocks
    UserService userService;

    @Test
    public void test() {
        when(userDao.getUserAge(anyLong())).thenCallRealMethod();
        Assertions.assertTrue(userService.checkUserAge(20));
        Assertions.assertFalse(userService.checkUserAge(10));
    }

    @Test
    public void testUserNotFound() {
        when(userDao.getUserAge(anyLong())).thenReturn(null);

        try {
            userService.checkUserAge(20);
        } catch (Exception e) {
            Assertions.assertInstanceOf(IllegalArgumentException.class, e);
        }
    }
}
