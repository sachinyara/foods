package com.foodservice.foods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * The bean configuration file.
 * 
 * @author SKumar6
 *
 */
@Configuration
public class FoodsApplicationConfig implements WebMvcConfigurer {
	@Bean
	public CommandLineRunner runner() {
		return args ->  {
			System.out.println("Hello!! Welcome to Food Service.");
		};
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new HandlerInterceptorAdapter() {

			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				response.setHeader("Access-Control-Allow-Origin", "*");
				return super.preHandle(request, response, handler);
			}

			
		});
	}
	
	
}
