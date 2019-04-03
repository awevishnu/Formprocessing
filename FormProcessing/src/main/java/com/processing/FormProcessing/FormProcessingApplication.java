package com.processing.FormProcessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.processing.FormProcessing.config"})
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FormProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormProcessingApplication.class, args);
	}

}
