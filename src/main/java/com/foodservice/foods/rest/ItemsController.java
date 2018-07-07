package com.foodservice.foods.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.foods.dto.ItemsWithCategory;
import com.foodservice.foods.service.ItemsService;

/**
 * The REST Controller to serve items related CRUD requests.
 * 
 * @author SKumar6
 *
 */
@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ItemsWithCategory> getAll(final HttpServletRequest request, final HttpServletResponse response) {
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
		System.out.println("DeviceId:" + deviceId);

		if (deviceId == null) {
			Cookie deviceIdcookie = new Cookie("_deviceId", UUID.randomUUID().toString());
			deviceIdcookie.setSecure(true);
			deviceIdcookie.setMaxAge(60 * 60 * 24 * 180);
			response.addCookie(deviceIdcookie);
		}
		if (userId == null) {
			Cookie userIdcookie = new Cookie("_userId", UUID.randomUUID().toString());
			userIdcookie.setSecure(true);
			userIdcookie.setMaxAge(60 * 60 * 24 * 180);
			response.addCookie(userIdcookie);
		}
		return itemsService.getAll();
	}
}
