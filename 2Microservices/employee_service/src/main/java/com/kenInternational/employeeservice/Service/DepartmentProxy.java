//package com.kenInternational.employeeservice.Service;
//
//import com.kenInternational.employeeservice.dto.DepartDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//
// If we are having the multiple instances of the department-service the if we have registered the
// instances in the eureka server service registry then we need to do the following code
//@FeignClient(name = "DEPARTMENT-SERVICE") // this open feign tag of the multiple instance
//@FeignClient(name = "DepartmentFeign",value = "Department-Service",url = "http://localhost:8080")
//public interface DepartmentProxy {
//    @GetMapping("api/departments/{department-code}")
//     DepartDto getDepartment(@PathVariable("department-code") String departmentCode);
//}
