package com.foodservice.foods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodservice.foods.domain.Items;
/**
 * The database repository interface for the {@link Items} entity.
 * 
 * @author SKumar6
 */
public interface ItemsRepository  extends JpaRepository<Items, Long>{

}
