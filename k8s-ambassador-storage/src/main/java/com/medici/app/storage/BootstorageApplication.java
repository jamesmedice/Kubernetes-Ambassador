package com.medici.app.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

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

}
