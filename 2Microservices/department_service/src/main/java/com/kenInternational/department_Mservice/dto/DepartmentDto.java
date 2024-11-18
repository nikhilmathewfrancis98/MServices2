package com.kenInternational.department_Mservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @JsonProperty("departmentName")
    private String departmentName;
    @JsonProperty("departmentDescription")
    private String departmentDescription;
    @JsonProperty("departmentCode")
    private String departmentCode;
//    @Value("${spring.boot.message}")
    private String Msg_value;

}