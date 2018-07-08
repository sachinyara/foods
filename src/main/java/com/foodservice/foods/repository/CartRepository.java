package com.foodservice.foods.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.foodservice.foods.domain.Cart;

/**
 * The database repository interface for the {@link Cart} entity.
 * 
 * @author SKumar6
 */
public interface CartRepository extends JpaRepository<Cart, Long>{
	List<Cart> findAllByUserId(final Long userId);
	
	@Transactional
	@Modifying
	void deleteByUserIdAndItemId(@Param("userId") final Long userId, @Param("itemId") final Long itemId);
}
