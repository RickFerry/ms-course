package br.com.study.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
    
}
