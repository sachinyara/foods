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
	List<Cart> create(final Long userId, final Cart cart);
	List<Cart> delete(final Long userId, final Cart cart);
}
