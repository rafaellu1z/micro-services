package com.rafael.hrpayroll.services;

import com.rafael.hrpayroll.entities.Payment;
import com.rafael.hrpayroll.entities.Worker;
import com.rafael.hrpayroll.exceptions.WorkerFeignException;
import com.rafael.hrpayroll.feignclients.WorkerFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignClient workerFeignClient;

  public Payment getPayment(Long workerId, Integer days) {

    try {
      Worker worker = workerFeignClient.findById(workerId).getBody();
      return new Payment(worker.getName(), worker.getDailyIncome(), days);
    } catch (FeignException e) {
      throw new WorkerFeignException(e.status(), e.getMessage());
    } catch (Exception e) {
      throw new WorkerFeignException(500, e.getMessage());
    }
  }

}
