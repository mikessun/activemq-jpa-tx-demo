package com.msun.spring.tx.user.impl;

import java.util.List;

import com.msun.spring.tx.dao.UserDAO;
import com.msun.spring.tx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msun.spring.tx.user.UserManager;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDAO.findUserByUserName(userName);
    }
}
