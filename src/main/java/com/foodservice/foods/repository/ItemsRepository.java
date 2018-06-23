package com.foodservice.foods.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodservice.foods.domain.Items;
/**
 * The database repository interface for the {@link Items} entity.
 * 
 * @author SKumar6
 */
public interface ItemsRepository  extends JpaRepository<Items, Long>{
	
	@Query("select i from Items i join fetch i.itemCategory")
	List<Items> getAll();

}
