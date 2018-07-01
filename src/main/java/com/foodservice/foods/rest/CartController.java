package com.foodservice.foods.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.foods.domain.Cart;
import com.foodservice.foods.service.CartService;

/**
 * The REST Controller to serve cart related CRUD requests.
 * 
 * @author SKumar6
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(value="{userId}", method = RequestMethod.GET)
	public List<Cart> get(final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable final Long userId) {
		String deviceId = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if ("_deviceId".equals(cookie.getName())) {
					deviceId = cookie.getValue();
				}
			}
		System.out.println("DeviceId:" + deviceId);

		if (deviceId == null) {
			Cookie deviceIdcookie = new Cookie("_deviceId", UUID.randomUUID().toString());
			deviceIdcookie.setSecure(true);
			deviceIdcookie.setMaxAge(60 * 60 * 24 * 180);
			System.out.println(deviceIdcookie.getDomain());
			response.addCookie(deviceIdcookie);
		}
		return cartService.get(userId);
	}
}
