package com.foodservice.foods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.foods.domain.Items;
import com.foodservice.foods.dto.ItemsWithCategory;
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
	public List<ItemsWithCategory> getAll() {
		List<Items> items = itemsRepository.getAll();
		List<ItemsWithCategory> itemsWithCategories = new ArrayList<>();
		
		items.stream().forEach(item -> {
			
			Optional<ItemsWithCategory> itemCategoryOptional = itemsWithCategories.stream()
			.filter(itemsWithCategory -> itemsWithCategory.getCategoryId().equals(item.getItemCategory().getId()))
			.findAny();
			
			if(itemCategoryOptional.isPresent()) {
				ItemsWithCategory itemsWithCategory = itemCategoryOptional.get();
				itemsWithCategory.getItems().add(item);
			}
			else {
				ItemsWithCategory itemsWithCategory = new ItemsWithCategory();
				itemsWithCategory.setCategoryId(item.getItemCategory().getId());
				itemsWithCategory.setCategory(item.getItemCategory().getName());
				itemsWithCategory.getItems().add(item);
				itemsWithCategories.add(itemsWithCategory);
			}
		});
		return itemsWithCategories;
	}

}
