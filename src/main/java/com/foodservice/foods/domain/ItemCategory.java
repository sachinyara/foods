package com.foodservice.foods.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ITEM_CATEGORY")
public class ItemCategory {
	
	@Id
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", name=" + name + "]";
	}
}
