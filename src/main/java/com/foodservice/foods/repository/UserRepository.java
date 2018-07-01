package com.foodservice.foods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodservice.foods.domain.User;

/**
 * The database repository interface for the {@link User} entity.
 * 
 * @author SKumar6
 */
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u.id from User u where u.deviceId = :deviceId")
	Long findByDeviceId(@Param("deviceId") final String deviceId);
}
