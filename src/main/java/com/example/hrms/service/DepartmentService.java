package com.example.hrms.service;

import com.example.hrms.model.dto.DepartmentDTO;
import com.example.hrms.model.entity.Department;
import com.example.hrms.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentDTO create(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        department = departmentRepository.save(department);
        return toDTO(department);
    }

    private DepartmentDTO toDTO(Department department) {
        return new DepartmentDTO(department.getName(), department.getDescription());
    }
}
