package com.foodservice.foods.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * The class for the {@link Items} entity.
 * 
 * @author SKumar6
 */
@Entity
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
	
	@Column(name = "ITEM_IMAGE")
	private byte[] itemImage;
	
	@OneToOne
	@JoinColumn(name ="ITEM_CATEGORY_ID", insertable = false, updatable = false)
	private ItemCategory itemCategory;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "IS_AVAILABLE")
	private Boolean available;
	
	@Column(name = "IS_VEG")
	private Boolean isVeg;
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column(name = "LAST_UPDATED_DATE")
	@UpdateTimestamp
	private Date lastUpdatedDate;
	
	@Column(name = "CREATION_DATE")
	@CreationTimestamp
	private Date creationDate;

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

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
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

	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description +  
				", itemImage=" + Arrays.toString(itemImage) + ", itemCategory=" + itemCategory
				+ ", price=" + price + ", available=" + available + ", isVeg=" + isVeg + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", creationDate=" + creationDate + "]";
	}
}
