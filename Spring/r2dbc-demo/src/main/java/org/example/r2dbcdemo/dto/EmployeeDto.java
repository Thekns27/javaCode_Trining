package org.example.r2dbcdemo.dto;

import org.example.r2dbcdemo.entity.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.io.Serializable;

public interface EmployeeDto extends R2dbcRepository <Employee, Integer> {

}
