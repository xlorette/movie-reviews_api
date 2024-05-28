package dev.movies.exceptions;

public abstract class ApiErrorRuntimeException extends RuntimeException implements ApiError {

  public ApiErrorRuntimeException(String message) {
    super(message);
  }
}
