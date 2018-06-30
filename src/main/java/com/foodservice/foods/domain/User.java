package com.foodservice.foods.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The class for the {@link User} entity.
 * 
 * @author SKumar6
 *
 */
@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQUENCE")
	@SequenceGenerator(name = "USERS_SEQUENCE", sequenceName = "USERS_SEQUENCE", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DEVICE_ID")
	private String deviceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userId=" + userId + ", password=" + password + ", deviceId=" + deviceId + "]";
	}
}
