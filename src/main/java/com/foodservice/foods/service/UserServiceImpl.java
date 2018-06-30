package com.foodservice.foods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.foods.domain.User;
import com.foodservice.foods.repository.UserRepository;
/**
 * The service implementation class to perform CRUD on {@link User}.
 * 
 * @author SKumar6
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User get(final String deviceId) {
		return userRepository.findByDeviceId(deviceId);
	}

	@Override
	public void create(User user) {
		userRepository.save(user);
	}

}
