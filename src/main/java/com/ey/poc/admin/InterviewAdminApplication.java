package com.ey.poc.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan({"com.ey.poc.*"})
@EnableJpaRepositories("com.ey.poc.*")
@EntityScan("com.ey.poc.entity")
@CrossOrigin(origins = "*")
public class InterviewAdminApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(InterviewAdminApplication.class, args);
		
	}

}
