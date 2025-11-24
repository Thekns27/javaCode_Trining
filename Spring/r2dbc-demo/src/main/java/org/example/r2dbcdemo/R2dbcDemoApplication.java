package org.example.r2dbcdemo;

import lombok.RequiredArgsConstructor;
import org.example.r2dbcdemo.entity.Employee;
import org.example.r2dbcdemo.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class R2dbcDemoApplication {
private final EmployeeRepository employeeRepository;
        @Bean @Profile("dev")
        public ApplicationRunner runner() {
            return r -> {
                Employee e1 = new Employee("johm","Doe","jonnn@gmail.com","555-555");
                Employee e1 = new Employee("Kyaw","Naing","Kyaw@gmail.com","555-555");
                employeeRepository.save(e1).subscripe;
            }
        }
    public static void main(String[] args) {
        SpringApplication.run(R2dbcDemoApplication.class, args);
    }

}
