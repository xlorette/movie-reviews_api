package dev.movies.configs;

import dev.movies.exceptions.ApiError;
import dev.movies.exceptions.ApiErrorRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ApiErrorRuntimeException.class})
    ResponseEntity<ApiError> handleApiErrorAwareRuntimeException(ApiErrorRuntimeException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity(ex.getMessage(), ex.getHttpStatus());
    }
}
