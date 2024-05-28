package dev.movies.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends ApiErrorRuntimeException {

  public EntityNotFoundException(String msg) {
    super(msg);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.NOT_FOUND;
  }
}
