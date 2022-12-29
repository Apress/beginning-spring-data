package com.apress.catalog.exception;

import com.apress.catalog.dto.ValidationErrorDTO;
import com.apress.catalog.dto.ViolationDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorDTO onConstraintValidationException(
            ConstraintViolationException e) {
        ValidationErrorDTO error = new ValidationErrorDTO();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            error.getViolations().add(
                    new ViolationDTO(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return error;
    }
}
