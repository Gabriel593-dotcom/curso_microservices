package com.mscourse.hrworker.resources;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hrworker.entities.Worker;
import com.mscourse.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/api/workers")
public class WorkerResource {
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll(); 
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        // try {
        //     Thread.sleep(3000L);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        logger.info("PORT: " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get(); 
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG: " + testConfig);
        return ResponseEntity.noContent().build();
    }
    
}
