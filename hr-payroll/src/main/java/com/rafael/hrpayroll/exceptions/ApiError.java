package com.rafael.hrpayroll.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

  private int status;
  private String error;
  private String message;

}
