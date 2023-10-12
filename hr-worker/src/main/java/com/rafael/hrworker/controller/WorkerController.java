package com.rafael.hrworker.controller;

import com.rafael.hrworker.entities.Worker;
import com.rafael.hrworker.services.WorkerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

  @Autowired
  private WorkerService workerService;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = workerService.findAllWorkers();
    return ResponseEntity.ok(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    Worker worker = workerService.findWorkerById(id);
    return ResponseEntity.ok(worker);
  }

}
