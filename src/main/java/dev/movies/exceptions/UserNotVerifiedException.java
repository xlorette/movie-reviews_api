package dev.movies.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotVerifiedException extends ApiErrorRuntimeException {

  public UserNotVerifiedException(String msg) {
    super(msg);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.UNPROCESSABLE_ENTITY;
  }
}
