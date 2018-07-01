/**
 * 
 */
package com.foodservice.foods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.foods.domain.Cart;
import com.foodservice.foods.repository.CartRepository;

/**
 * The service implementation class to perform CRUD on {@link Cart}.
 * 
 * @author SKumar6
 *
 */
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> get(final Long userId) {
		return cartRepository.findAllByUserId(userId);
	}

	@Override
	public List<Cart> create(final Long userId, final Cart cart) {
		cartRepository.save(cart);
		return cartRepository.findAllByUserId(userId);
	}

	@Override
	public List<Cart> delete(final Long userId, final Cart cart) {
		cartRepository.delete(cart);
		return cartRepository.findAllByUserId(userId);
	}

}
