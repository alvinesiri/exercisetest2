package com.exercise2.service.payment;

import com.exercise2.exception.PaymentException;
import com.exercise2.model.Bill;

public interface PaymentService {
    double GetNetPayableAmount(Bill bill) throws PaymentException;
}
