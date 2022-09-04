package com.riddhi.employeemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeemanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanageApplication.class, args);
	}

}
