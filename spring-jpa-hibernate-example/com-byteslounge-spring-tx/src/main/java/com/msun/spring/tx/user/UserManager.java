package com.msun.spring.tx.user;

import java.util.List;

import com.msun.spring.tx.model.User;

public interface UserManager {

	void insertUser(User user);

	List<User> findAllUsers();

	User findUserByUserName(String userName);
}
