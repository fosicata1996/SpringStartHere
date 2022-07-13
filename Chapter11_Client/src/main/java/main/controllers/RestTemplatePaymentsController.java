package main.controllers;

import main.entities.Payment;
import main.proxy.RestTemplatePaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplatePaymentsController {

    private final RestTemplatePaymentsProxy paymentsProxy;


    public RestTemplatePaymentsController(RestTemplatePaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/resttemplate/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
