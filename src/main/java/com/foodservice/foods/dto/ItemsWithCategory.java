package com.foodservice.foods.dto;

import java.util.ArrayList;
import java.util.List;

import com.foodservice.foods.domain.Items;

public class ItemsWithCategory implements Comparable<ItemsWithCategory>{
	private Long categoryId;
	private String category;
	private List<Items> items = new ArrayList<>();
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public int compareTo(ItemsWithCategory o) {
		return o.category.compareTo(this.category);
	}
}
