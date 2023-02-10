package br.com.study.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.study.hrpayroll.entities.Payment;
import br.com.study.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/payments")
public class PaymentResource {
    
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days ){
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        return ResponseEntity.ok(new Payment("Brann", 400.0, days));
    }
}
