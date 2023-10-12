package com.rafael.hrpayroll.services;

import com.rafael.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public Payment getPayment(Long workerId, Integer days) {
    return new Payment("Bob", 200.0, days);
  }

}
