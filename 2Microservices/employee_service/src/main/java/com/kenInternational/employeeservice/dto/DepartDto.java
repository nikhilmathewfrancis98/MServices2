package com.kenInternational.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartDto {
    private Long id;
    @JsonProperty("departmentName")
    private String departmentName;
    @JsonProperty("departmentDescription")
    private  String departmentDescription;
    @JsonProperty("departmentCode")
    private String departmentCode;
}