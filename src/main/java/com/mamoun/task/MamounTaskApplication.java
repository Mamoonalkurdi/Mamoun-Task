package com.mamoun.task;

import com.mamoun.task.service.SeedService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MamounTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MamounTaskApplication.class, args);

		SeedService seedService = context.getBean(SeedService.class);

		seedService.seedData();
	}

}
