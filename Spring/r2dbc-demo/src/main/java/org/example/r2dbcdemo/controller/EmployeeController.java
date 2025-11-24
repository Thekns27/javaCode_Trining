package org.example.r2dbcdemo.controller;


import lombok.RequiredArgsConstructor;
import org.example.r2dbcdemo.dto.EmployeeDto;
import org.example.r2dbcdemo.repository.EmployeeRepository;
import org.example.r2dbcdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public Flux<EmployeeDto> listAllEmployee() {
        return employeeService.listAllEmployee();
    }
    @PostMapping("/employees/{id}")
    public Mono<EmployeeDto> getEmployee(EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);

    }

}
