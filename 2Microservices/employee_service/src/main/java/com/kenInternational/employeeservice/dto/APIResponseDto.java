package com.kenInternational.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDto {
    private EmployeeDto employee;
    private DepartDto department;
    private OrganizationDto organization;
}