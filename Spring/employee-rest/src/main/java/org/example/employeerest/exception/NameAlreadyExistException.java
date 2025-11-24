package org.example.employeerest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class NameAlreadyExistException extends ResponseStatusException {
    public NameAlreadyExistException( String name) {
        super(HttpStatus.BAD_REQUEST);
    }
}
