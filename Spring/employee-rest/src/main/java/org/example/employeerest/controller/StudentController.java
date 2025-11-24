package org.example.employeerest.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.example.employeerest.entity.Student;
import org.example.employeerest.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    record StudentRequest(@NotEmpty(message = "first name cannot be empty") String firstName,
                    String lastName,
                    String email,
                    String phoneNumber) {}
    @PostMapping("/students")
    public ResponseEntity
        createStudent(@RequestBody StudentRequest studentRequest) {
        var student = toStudent(studentRequest);
        return ResponseEntity.
                status(HttpStatus.CREATED).body(
                        studentService.createStudent(student));
    }
    private static Student toStudent(StudentRequest studentRequest) {
        var student = new Student();
        student.setFirstName(studentRequest.firstName);
        student.setLastName(studentRequest.lastName);
        student.setEmail(studentRequest.email);
        student.setPhoneNumber(studentRequest.phoneNumber);
        return student;
    }
}
