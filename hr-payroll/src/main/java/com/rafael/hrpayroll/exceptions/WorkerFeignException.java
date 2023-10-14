package com.rafael.hrpayroll.exceptions;

import feign.FeignException;

public class WorkerFeignException extends FeignException {

  public WorkerFeignException(int status, String message) {
    super(status, message);
  }

}
