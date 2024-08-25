package com.openfeign.employeeService.service;

import com.openfeign.employeeService.dto.EmployeeDTO;

public interface EmployeeService {
    public EmployeeDTO getEmployeeById(int id) throws Exception;
}
