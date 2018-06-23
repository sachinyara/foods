package com.foodservice.foods;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The main class.
 * 
 * @author SKumar6
 *
 */
@SpringBootApplication
public class FoodsApplication {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FoodsApplication.class);
		
		//Setting logger location.
		Properties properties = new Properties();
		String logPath = System.getProperty("log.path") + "\\foods.log";
		properties.put("logging.file", logPath);
		application.setDefaultProperties(properties);
		
		application.run(args);
	}
}
