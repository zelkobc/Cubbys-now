package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@ComponentScan(basePackages= {"com.revature.services.*"}) // For some reason, the project has broken into modules and those annotations are now necessary.
@EnableJpaRepositories(basePackages= {"com.revature.data.*"})
@EntityScan(basePackages={"com.revature.beans.*"})
public class PitchPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(PitchPlusApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "Greetings earthling!";
	}
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("GET", "OPTIONS", "PUT", "POST", "PATCH", "DELETE")
//                        .allowedOrigins("*").allowedHeaders("*").allowCredentials(true); 
//            }
//        };
    }

