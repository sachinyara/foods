package com.foodservice.foods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.foods.domain.Items;
import com.foodservice.foods.repository.ItemsRepository;

/**
 * The service implementation class to perform CRUD on food items.
 * 
 * @author SKumar6
 *
 */
@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public List<Items> getAll() {
		return itemsRepository.getAll();
	}

}
