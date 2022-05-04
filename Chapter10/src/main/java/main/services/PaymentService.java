package main.services;

import main.entities.PaymentDetails;
import main.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
