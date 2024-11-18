package com.kenInternational.employeeservice.Service;

import com.kenInternational.employeeservice.dto.APIResponseDto;
import com.kenInternational.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}