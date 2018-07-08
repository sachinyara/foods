package com.foodservice.foods.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * The class for the {@link Cart} entity.
 * 
 * @author SKumar6
 *
 */
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQUENCE")
	@SequenceGenerator(name = "CART_SEQUENCE", sequenceName = "CART_SEQUENCE", allocationSize = 1, initialValue = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "ITEM_ID")
	private Long itemId;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}
}
