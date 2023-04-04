package com.mscourse.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscourse.hrpayroll.entities.Payment;
import com.mscourse.hrpayroll.entities.Worker;
import com.mscourse.hrpayroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClients workerFeignClient; 

    public Payment getPayment(Long workerId, int days) {

        Worker worker = workerFeignClient.findByid(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);   
    }
}
