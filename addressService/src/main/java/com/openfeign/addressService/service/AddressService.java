package com.openfeign.addressService.service;

import com.openfeign.addressService.dto.AddressDTO;

public interface AddressService {
    public AddressDTO findAddressByEmployeeId(int employeeId) throws Exception;
}
