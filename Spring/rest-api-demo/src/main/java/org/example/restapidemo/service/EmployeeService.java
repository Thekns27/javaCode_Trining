package org.example.restapidemo.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.restapidemo.dao.EmployeeDao;
import org.example.restapidemo.ds.EmployeeDto;
import org.example.restapidemo.ds.Employees;
import org.example.restapidemo.entity.Employee;
import org.example.restapidemo.util.EntityUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public Employees getAllEmployeeV2(){
        List<EmployeeDto> empList=employeeDao
                .findAll()
                .stream()
                .map(EntityUtil::employeeDto)
                .collect(Collectors.toList());
        return new Employees(empList);
    }

    public void deleteEmployee(int id){
        employeeDao.deleteById(id);
    }

    public EmployeeDto updateEmployeeEmail(String email,int id){
        if(employeeDao.existsById(id)){
            Employee employee=employeeDao.findById(id).get();
            employee.setId(id);
            employee.setEmail(email);
            return EntityUtil.employeeDto(employeeDao.save(employee));
        }
         throw new EntityNotFoundException(id + " Not Found!");
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto,int id){
        if(employeeDao.existsById(id)){
            Employee employee=EntityUtil.toEmployeeEntity(employeeDto);
            employee.setId(id);
            return EntityUtil.employeeDto(employeeDao.save(employee));
        }
        throw new EntityNotFoundException(id + " Not Found.");
    }

    public List<EmployeeDto> listAllEmployee(){
        return  employeeDao.findAll()
                .stream()
                .map(EntityUtil::employeeDto)
                .collect(Collectors.toList());
    }
    public EmployeeDto findEmployeeById(int id){
        return employeeDao.findById(id)
                .map(EntityUtil::employeeDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee=employeeDao.save(EntityUtil.toEmployeeEntity(employeeDto));
        return EntityUtil.employeeDto(employee);
    }
}
