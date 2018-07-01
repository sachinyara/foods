package com.foodservice.foods.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodservice.foods.domain.Cart;

/**
 * The database repository interface for the {@link Cart} entity.
 * 
 * @author SKumar6
 */
public interface CartRepository extends JpaRepository<Cart, Long>{
	List<Cart> findAllByUserId(final Long userId);
}
