package com.whiskypedia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(@NonNull CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/api/**")  // Adjust the mapping according to your API endpoints
//		.allowedOrigins("**")  // Adjust the origin to match your React frontend
		.allowedOrigins("http://localhost:3000")  // Adjust the origin to match your React frontend
		.allowedMethods("GET", "POST", "PUT", "DELETE")
		.allowCredentials(true);
	}
}
