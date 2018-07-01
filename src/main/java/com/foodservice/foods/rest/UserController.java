package com.foodservice.foods.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.foods.service.UserService;

/**
 * 
 * 
 * @author SKumar6
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="{deviceId}", method = RequestMethod.GET)
	public Long get(@PathVariable final String deviceId) {
		return userService.get(deviceId);
	}

}
