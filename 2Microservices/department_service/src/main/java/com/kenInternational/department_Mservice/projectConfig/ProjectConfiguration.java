package com.kenInternational.department_Mservice.projectConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    @Bean(name = "GetMapper")
    public ModelMapper GetMapper(){
        return new ModelMapper();
    }
}
