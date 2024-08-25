package com.openfeign.addressService.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
