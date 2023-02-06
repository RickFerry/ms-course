package br.com.study.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.study.hrpayroll.entities.Payment;
import br.com.study.hrpayroll.entities.Worker;
import br.com.study.hrpayroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;
    
    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findWorker(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
