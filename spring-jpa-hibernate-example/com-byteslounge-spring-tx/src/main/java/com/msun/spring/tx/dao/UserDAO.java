package com.msun.spring.tx.dao;

import java.util.List;

import com.msun.spring.tx.model.User;

public interface UserDAO {

	void insertUser(User user);

	List<User> findAllUsers();

	User findUserByUserName(String userName);
}
