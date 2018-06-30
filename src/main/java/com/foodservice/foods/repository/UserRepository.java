package com.foodservice.foods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodservice.foods.domain.User;

/**
 * The database repository interface for the {@link User} entity.
 * 
 * @author SKumar6
 */
public interface UserRepository extends JpaRepository<User, Long>{
	User findByDeviceId(final String deviceId);
}
