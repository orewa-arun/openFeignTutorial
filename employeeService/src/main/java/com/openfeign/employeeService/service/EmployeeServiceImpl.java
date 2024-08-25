package com.openfeign.employeeService.service;
import com.openfeign.employeeService.dto.EmployeeDTO;
import com.openfeign.employeeService.entity.Employee;
import com.openfeign.employeeService.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO getEmployeeById(int id) throws Exception {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()) {
            Employee employee = optional.get();
            return modelMapper.map(employee, EmployeeDTO.class);
        }else {
            throw new Exception("Employee with id " + id + " not found!");
        }
    }
}
