package com.foodservice.foods.service;

import java.util.List;

import com.foodservice.foods.domain.User;

/**
 * The service interface to perform CRUD on {@link User}.
 * 
 * @author SKumar6
 *
 */
public interface UserService {
	List<User> getAll();
	User get(final String deviceId);
	void create(final User user);
	
}
