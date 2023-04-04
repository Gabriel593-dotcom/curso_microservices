package com.mscourse.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mscourse.hrpayroll.entities.Worker;


@Component
@FeignClient(name = "hr-worker",  url = "http://localhost:8001", path = "/api/workers")
public interface WorkerFeignClients {
    
    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findByid(@PathVariable Long id);
}
