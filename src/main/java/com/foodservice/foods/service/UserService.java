package com.foodservice.foods.service;

import com.foodservice.foods.domain.User;

/**
 * The service interface to perform CRUD on {@link User}.
 * 
 * @author SKumar6
 *
 */
public interface UserService {
	Long get(final String userId, final String deviceId);
	User create(final User user);
	
}
