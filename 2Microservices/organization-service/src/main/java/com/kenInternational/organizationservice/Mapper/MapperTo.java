package com.kenInternational.organizationservice.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperTo {
    @Bean(name = "MapperObject")
    public ModelMapper GetMapper(){
        return new ModelMapper();
    }
}
