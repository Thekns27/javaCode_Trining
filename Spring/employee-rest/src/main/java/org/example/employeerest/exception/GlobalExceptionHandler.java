package org.example.employeerest.exception;

import com.fasterxml.jackson.databind.util.ExceptionUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler({SQLIntegrityConstraintViolationException.class,
                NameAlreadyExistException.class})
    public ResponseEntity<Object>exceptionHandler(Exception e,
                                                 WebRequest request)
    throws Exception{
        return handleExceptionInternal(e,
                message(e),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);

    }



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(ex,
                message(ex),
                 headers,
                status,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        return handleExceptionInternal(ex,
                message(ex),
                headers,
                status,
                request);
    }

    private ApiError message(Exception e) {
        String developerMessage = ExceptionUtils.getRootCauseMessage(e);
        return new ApiError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                developerMessage
                );

}


}

