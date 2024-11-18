package com.kenInternational.department_Mservice.controller;

/** Import note from chat GPT
 * Yes, you can use Spring Boot's Actuator /refresh endpoint along
 * with @RefreshScope to reload configurations from a properties file
 * without using a configuration server. However, it's essential to note that Spring Cloud
 * Config Server is typically used to manage and distribute configurations
 * across multiple instances of an application, making it easier to manage
 * configurations in a distributed environment.
 * Here's how you can achieve this:
 * Configure Actuator and RefreshScope:
 * Ensure that you have Actuator and RefreshScope dependencies included in your project.
 * Update Properties File:
 * Define your properties in the application.properties or application.yml file as usual.
 * Use @RefreshScope:
 * Annotate the beans that you want to refresh with @RefreshScope.
 * This tells Spring to recreate the bean when a refresh event occurs.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.greetings}")
    private String message;

    @GetMapping("message")
    public String message(){
        return message;
    }
}
