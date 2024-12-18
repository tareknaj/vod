package fr.vod.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig {
	
	@Value("${app.url}")
	private String allowedOrigin;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
			
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Allow all endpoints
						.allowedOrigins(allowedOrigin)
						/*.allowedOrigins("http://localhost:9091") // Allow React app origin */
						.allowedMethods("*") // Allow HTTP methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true); // Allow credentials (cookies, etc.)
			}
		};
	}
}
