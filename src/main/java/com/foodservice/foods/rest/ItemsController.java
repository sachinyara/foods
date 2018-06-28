package com.foodservice.foods.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodservice.foods.dto.ItemsWithCategory;
import com.foodservice.foods.service.ItemsService;

/**
 * The REST Controller to serve items related CRUD requests.
 * 
 * @author SKumar6
 *
 */
@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ItemsWithCategory> getAll(HttpServletResponse response) {
		return itemsService.getAll();
	}
	
}
