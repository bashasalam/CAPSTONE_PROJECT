package com.salambasha.medicare;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.salambasha.medicare.controller.ProductController;

@SpringBootApplication
@ComponentScan("com.salambasha.medicare")

@EntityScan("com.salambasha.medicare.entities")
@EnableJpaRepositories("com.salambasha.medicare.dao")
public class MedicareApplication {

	
	public static void main(String[] args) {
		new File (ProductController.uploadDirectory).mkdir();
		SpringApplication.run(MedicareApplication.class, args);
	}

}
