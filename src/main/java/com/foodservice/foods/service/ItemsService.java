package com.foodservice.foods.service;

import java.util.List;

import com.foodservice.foods.domain.Items;

/**
 * The service interface to perform CRUD on food items.
 * 
 * @author SKumar6
 *
 */
public interface ItemsService {
	List<Items> getAll();
}
