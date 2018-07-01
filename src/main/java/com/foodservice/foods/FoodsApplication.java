package com.foodservice.foods;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * The main class.
 * 
 * @author SKumar6
 *
 */
@SpringBootApplication
public class FoodsApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FoodsApplication.class);
		
		//Setting logger location.
		Properties properties = new Properties();
		String logPath = System.getProperty("log.path") + "\\foods.log";
		properties.put("logging.file", logPath);
		application.setDefaultProperties(properties);
		
		application.run(args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
			registry.addResourceHandler("/**").addResourceLocations(
					"classpath:/static/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
}
