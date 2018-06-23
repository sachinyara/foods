package com.foodservice.foods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foodservice.foods.repository.ItemsRepository;

/**
 * The bean configuration file.
 * 
 * @author SKumar6
 *
 */
@Configuration
public class FoodsApplicationConfig {
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Bean
	public CommandLineRunner runner() {
		return args ->  {
			System.out.println(itemsRepository.findById(1L));
			System.out.println("Hello!!");
		};
	}
}
