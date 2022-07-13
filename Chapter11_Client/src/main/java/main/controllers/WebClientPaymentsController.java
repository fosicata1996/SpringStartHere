package main.controllers;

import main.entities.Payment;
import main.proxy.WebClientPaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WebClientPaymentsController {
    private final WebClientPaymentsProxy paymentsProxy;

    public WebClientPaymentsController(WebClientPaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/webclient/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
