package com.kenInternational.employeeservice;
/**
 * Don’t annotate an entry-point EmployeeServiceApplication class with @EnableEurekaClient
 * - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
