package com.foodservice.foods.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Items item;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [user=" + user + ", item=" + item + ", quantity=" + quantity + "]";
	}
}
