package com.openfeign.employeeService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private int id;
    private String name;
    private String email;
    private int age;
    private AddressDTO addressDTO;
}
