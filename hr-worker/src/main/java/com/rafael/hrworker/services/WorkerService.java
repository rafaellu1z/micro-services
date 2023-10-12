package com.rafael.hrworker.services;

import com.rafael.hrworker.entities.Worker;
import com.rafael.hrworker.exceptions.WorkerNotFoundException;
import com.rafael.hrworker.repositories.WorkerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

  @Autowired
  private WorkerRepository repository;

  public List<Worker> findAllWorkers() {
    return repository.findAll();
  }

  public Worker findWorkerById(Long id) {
      return repository.findById(id).orElseThrow(() -> new WorkerNotFoundException(id));
  }

}
