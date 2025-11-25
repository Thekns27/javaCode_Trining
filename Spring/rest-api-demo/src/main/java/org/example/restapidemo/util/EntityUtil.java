package org.example.restapidemo.util;

import org.example.restapidemo.ds.EmployeeDto;
import org.example.restapidemo.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static EmployeeDto employeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;
    }
    public static Employee toEmployeeEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return employee;
    }
}
