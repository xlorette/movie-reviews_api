package dev.movies.exceptions;

import org.springframework.http.HttpStatus;

public class ExistingCredentialsException extends ApiErrorRuntimeException {

  public ExistingCredentialsException(String msg) {
    super(msg);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.CONFLICT;
  }
}
