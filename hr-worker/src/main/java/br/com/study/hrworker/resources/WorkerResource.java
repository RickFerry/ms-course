package br.com.study.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.hrworker.entities.Worker;
import br.com.study.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerResource {
    
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    private final WorkerRepository workerRepository;
    private final Environment env;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findWorker(@PathVariable Long id){
        logger.info("PORT= " + env.getProperty("local.server.port"));
        return ResponseEntity.ok(workerRepository.findById(id).orElse(null));
    }
}
