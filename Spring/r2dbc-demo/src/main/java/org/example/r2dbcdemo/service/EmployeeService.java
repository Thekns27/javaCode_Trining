package org.example.r2dbcdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.r2dbcdemo.dto.EmployeeDto;
import org.example.r2dbcdemo.repository.EmployeeRepository;
import org.example.r2dbcdemo.util.EntityUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Mono<EmployeeDto> updateEmployee(int id,EmployeeDto employeeDto) {
        return employeeRepository.findById(id)
                .flatMap(e->Mono.just(employeeDto)
                        .map(EntityUtil::toEmployee)
                        .doOnNext(a -> a.setId(id)))
                .flatMap(employeeRepository::save)
                .map(EntityUtil::toEmployeeDto);
    }
}
