package br.com.study.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.hrworker.entities.Worker;
import br.com.study.hrworker.repositories.WorkerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerResource {

	@NonNull
	private WorkerRepository workerRepository;

	@NonNull
	private Environment env;

	@Value("${test.config}")
	private String testConfig;

	@GetMapping("/configs")
	public ResponseEntity<List<Void>> getConfigs() {
		log.info("CONFIG= " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAllWorkers() {
		return ResponseEntity.ok(workerRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findWorker(@PathVariable Long id) throws Exception {
		log.info("PORT= " + env.getProperty("local.server.port"));
		return ResponseEntity
				.ok(workerRepository.findById(id).orElseThrow(() -> new Exception("Worker id " + id + " not found.")));
	}
}
