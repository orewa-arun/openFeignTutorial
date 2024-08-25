package com.openfeign.employeeService.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Creates the modelMapper bean in spring container
// which is then injected in employee controller
@Configuration
public class EmployeeConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
