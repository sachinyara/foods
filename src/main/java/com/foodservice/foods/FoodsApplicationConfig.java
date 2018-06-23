package com.foodservice.foods;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The bean configuration file.
 * 
 * @author SKumar6
 *
 */
@Configuration
public class FoodsApplicationConfig {
	@Bean
	public CommandLineRunner runner() {
		return args ->  {
			System.out.println("Hello!! sWelcome to Food Service.");
		};
	}
}
