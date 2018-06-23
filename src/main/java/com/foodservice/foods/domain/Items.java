package com.foodservice.foods.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * The class for the {@link Items} entity.
 * 
 * @author SKumar6
 */
@Entity(name="ITEMS")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMS_SEQUENCE")
	@SequenceGenerator(name = "ITEMS_SEQUENCE", sequenceName = "ITEMS_SEQUENCE", allocationSize = 1, initialValue = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "ITEM_IMAGE_NAME")
	private String itemImageName;
	
	@Column(name = "ITEM_IMAGE")
	private byte[] itemImage;
	
	@OneToOne
	@JoinColumn(name ="ID", table = "ITEM_CATEGORY", insertable = false, updatable = false)
	private ItemCategory itemCategory;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "IS_AVAILABLE")
	private Boolean available;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemImageName() {
		return itemImageName;
	}

	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategoryId(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", itemImageName="
				+ itemImageName + ", itemImage=" + Arrays.toString(itemImage) + ", itemCategory=" + itemCategory
				+ ", price=" + price + ", available=" + available + "]";
	}

	
}
