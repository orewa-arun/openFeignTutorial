package com.openfeign.addressService.service;

import com.openfeign.addressService.dto.AddressDTO;
import com.openfeign.addressService.entity.Address;
import com.openfeign.addressService.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDTO findAddressByEmployeeId(int employeeId) throws Exception {
        Optional<Address> optional = addressRepository.findAddressByEmployeeId(employeeId);

        if(optional.isPresent()){
            Address address = optional.get();
            return modelMapper.map(address, AddressDTO.class);
        }else {
            throw new Exception("employee with id : " + employeeId + " not found!");
        }
    }
}
