package main.controllers;

import main.entities.Payment;
import main.proxy.OpenFeignPaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OpenFeignPaymentsController {

    private final OpenFeignPaymentsProxy paymentsProxy;


    public OpenFeignPaymentsController(OpenFeignPaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
