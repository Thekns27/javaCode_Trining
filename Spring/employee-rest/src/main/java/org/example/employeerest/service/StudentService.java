package org.example.employeerest.service;

import lombok.RequiredArgsConstructor;
import org.example.employeerest.dao.StudentDao;
import org.example.employeerest.entity.Student;
import org.example.employeerest.exception.NameAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;


    public String createStudent(Student student) {
        if (studentDao.existsByFirstNameAndLastName(
                student.getFirstName(), student.getLastName()
        )){
            throw new NameAlreadyExistException(
                    student.getFirstName() + " " + student.getLastName()
            );
        }

        studentDao.save(student);
        return "student successfully created";
    }
}
