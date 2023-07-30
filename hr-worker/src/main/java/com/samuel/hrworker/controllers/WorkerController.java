package com.samuel.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.hrworker.entities.Worker;
import com.samuel.hrworker.repositories.IWorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private IWorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}
}
