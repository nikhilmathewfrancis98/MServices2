package com.kenInternational.department_Mservice.services.Impl;

import com.kenInternational.department_Mservice.Exception.ResourceNotFoundException;
import com.kenInternational.department_Mservice.entity.Department;
import com.kenInternational.department_Mservice.services.DepartmentService;
import com.kenInternational.department_Mservice.repository.DepartmentRepository;
import com.kenInternational.department_Mservice.dto.DepartmentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public ModelMapper DepartmentMapper;
    @Value("${spring.boot.greetings}")
    private String message;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.map(savedDepartment,DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if (department==null){
            throw new ResourceNotFoundException("The Resource you are looking for is not found!");
        }
        DepartmentDto departmentDto = DepartmentMapper.map(department,DepartmentDto.class);
        departmentDto.setMsg_value(message);
        return departmentDto;
    }
}
