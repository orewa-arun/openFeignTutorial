package com.openfeign.employeeService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private int id;
    private String city;
    private String state;
}
