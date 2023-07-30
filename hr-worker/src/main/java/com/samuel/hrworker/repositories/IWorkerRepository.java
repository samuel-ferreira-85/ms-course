package com.samuel.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuel.hrworker.entities.Worker;

public interface IWorkerRepository extends JpaRepository<Worker, Long> {

}
