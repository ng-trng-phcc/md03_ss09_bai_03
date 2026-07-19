package com.example.hrms.controller;

import com.example.hrms.common.ApiResponse;
import com.example.hrms.model.dto.EmployeeCreateDTO;
import com.example.hrms.model.dto.EmployeeDTO;
import com.example.hrms.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeDTO>> create(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO) {
        EmployeeDTO created = employeeService.create(employeeCreateDTO);
        ApiResponse<EmployeeDTO> response = ApiResponse.success("Nhân viên đã được tạo thành công", created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
