package com.pru.shifty.api.service;

import java.util.List;

import com.pru.shifty.api.model.User;



public interface UserService {
	
	User get(long id);
	User getByUsername(String name);
	User create(User user);
	void update(long id, User user);
	void delete(long id);
	List<User> findAllUsers();
	boolean isUserExist(User user);
	
}
