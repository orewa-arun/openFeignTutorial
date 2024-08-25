package com.openfeign.employeeService.service;
import com.openfeign.employeeService.dto.AddressDTO;
import com.openfeign.employeeService.dto.EmployeeDTO;
import com.openfeign.employeeService.entity.Employee;
import com.openfeign.employeeService.feignClient.AddressClient;
import com.openfeign.employeeService.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;

    @Override
    public EmployeeDTO getEmployeeById(int id) throws Exception {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            ResponseEntity<AddressDTO> address = addressClient.getAddressByEmployeeId(id);
            employeeDTO.setAddressDTO(address.getBody());
            return employeeDTO;
        }else {
            throw new Exception("Employee with id " + id + " not found!");
        }
    }
}
