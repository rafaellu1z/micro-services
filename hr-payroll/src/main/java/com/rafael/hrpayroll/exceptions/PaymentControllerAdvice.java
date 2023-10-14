package com.rafael.hrpayroll.exceptions;

import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerAdvice {

  @ExceptionHandler(WorkerFeignException.class)
  @ResponseBody
  public ApiError handleWorkerFeignException(WorkerFeignException e, HttpServletResponse response) {
    int status = e.status() != -1 ? e.status() : HttpStatus.INTERNAL_SERVER_ERROR.value();
    response.setStatus(status);
    return new ApiError(e.status(), Objects.requireNonNull(HttpStatus.resolve(status)).getReasonPhrase(), e.getMessage());
  }

}
