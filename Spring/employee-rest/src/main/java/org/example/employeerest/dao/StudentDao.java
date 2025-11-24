package org.example.employeerest.dao;

import org.example.employeerest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}


