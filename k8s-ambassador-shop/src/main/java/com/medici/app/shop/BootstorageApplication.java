package com.medici.app.shop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author a73s
 *
 */
@SpringBootApplication
@EnableCaching
public class BootstorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstorageApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
