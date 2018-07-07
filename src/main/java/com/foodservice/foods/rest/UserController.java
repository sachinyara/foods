package com.foodservice.foods.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.foods.domain.User;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public Long get(HttpServletRequest request) {
		String deviceId = null;
		String userId = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if("_deviceId".equals(cookie.getName())) {
					deviceId = cookie.getValue();
				}
				if("_userId".equals(cookie.getName())) {
					userId = cookie.getValue();
				}
			}
		Long id = null;
		if(!(deviceId == null && userId == null))
			id = userService.get(userId, deviceId);
		if(id == null) {
			User user = new User();
			user.setDeviceId(deviceId);
			id = userService.create(user).getId();
		}
		return id;
	}
}
