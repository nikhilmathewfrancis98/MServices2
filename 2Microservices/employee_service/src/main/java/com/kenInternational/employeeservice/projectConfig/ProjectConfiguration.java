package com.kenInternational.employeeservice.projectConfig;

import org.modelmapper.ModelMapper;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {
    @Bean(name = "GetMapper")
    public ModelMapper GetMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public RestTemplate restTemplate(){
//       return new RestTemplate();
//    }

    @Bean
    public WebClient webClient(){
        return  WebClient.builder().build();
    }
}
