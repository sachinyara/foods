package com.foodservice.foods.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Cart> get(@PathVariable final Long userId) {
		return cartService.get(userId);
	}
	@RequestMapping(value = "{userId}", method = RequestMethod.POST)
	public List<Cart> add(@PathVariable final Long userId, @RequestBody final Cart cart) {
		return cartService.add(userId, cart);
	}
	
	@RequestMapping(value = "{userId}", method = RequestMethod.PUT)
	public List<Cart> remove(@PathVariable final Long userId, @RequestBody final Cart cart) {
		return cartService.remove(userId, cart);
	}
}
