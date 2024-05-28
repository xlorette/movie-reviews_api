package dev.movies.exceptions;

import org.springframework.http.HttpStatus;

public interface ApiError {

  HttpStatus getHttpStatus();
}
