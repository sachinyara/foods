package com.foodservice.foods.service;

import java.util.List;

import com.foodservice.foods.domain.Cart;

/**
 * The service interface to perform CRUD on {@link Cart}.
 * @author SKumar6
 *
 */
public interface CartService {
	List<Cart> get(final Long userId);
	List<Cart> add(final Long userId, final Cart cart);
	List<Cart> remove(final Long userId, final Cart cart);
	void remove(Long userId, Long itemId);
}
