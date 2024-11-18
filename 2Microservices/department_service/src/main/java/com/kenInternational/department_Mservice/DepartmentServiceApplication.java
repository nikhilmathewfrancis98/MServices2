package com.kenInternational.department_Mservice;
/**
 * Don’t annotate an entry-point DepartmentServiceApplication class with @EnableEurekaClient
 * - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
