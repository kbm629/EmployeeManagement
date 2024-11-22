// Configuration class which has beans of the all the objects

package com.employeeData.EmployeeManagement.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    // Model mapper is used to convert one type of data into another type provide facility to do that task automatically
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
