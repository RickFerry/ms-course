package br.com.study.hrworker.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.hrworker.entities.Worker;
import br.com.study.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/workers")
public class WorkerResource {
    
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findWorker(@PathVariable Long id){
        return ResponseEntity.ok(workerRepository.findById(id).orElse(null));
    }
}
