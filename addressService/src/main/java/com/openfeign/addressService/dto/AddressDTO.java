package com.openfeign.addressService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private int id;
    private String state;
    private String city;
}
