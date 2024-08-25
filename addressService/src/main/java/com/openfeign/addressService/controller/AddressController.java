package com.openfeign.addressService.controller;

import com.openfeign.addressService.dto.AddressDTO;
import com.openfeign.addressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<Object> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){
        try {
            AddressDTO address = addressService.findAddressByEmployeeId(employeeId);
            return ResponseEntity.status(HttpStatus.OK).body(address);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
