package com.example.demo.dao;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Integer getUserAge(Integer userId) {
        return userId;
    }

    public UserDao () {}

    @Transactional
    public void saveUser(User user) {
      logger.info("save user: {}", user);
      entityManager.persist(user);
    }

    @Transactional
    public User getUser(Integer userId) {
        return entityManager.find(User.class, userId);
    }
}
