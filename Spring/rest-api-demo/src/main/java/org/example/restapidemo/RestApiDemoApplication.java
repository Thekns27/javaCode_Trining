package org.example.restapidemo;

import lombok.RequiredArgsConstructor;
import org.example.restapidemo.dao.EmployeeDao;
import org.example.restapidemo.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class RestApiDemoApplication {
    private final EmployeeDao employeeDao;
    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r ->{
            Employee employee1=new Employee("John","Doe","john@gmail.com","55-555-55",2000);
            Employee employee2=new Employee("Mary","Shelly","mary@gmail.com","55-555-56",2500);
            employeeDao.save(employee1);
            employeeDao.save(employee2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiDemoApplication.class, args);
    }

}
