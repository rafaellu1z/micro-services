package com.rafael.hrworker.exceptions;

public class WorkerNotFoundException extends RuntimeException {

  public WorkerNotFoundException(Long id) {
    super("Worker not found. Id: " + id + ".");
  }

}
