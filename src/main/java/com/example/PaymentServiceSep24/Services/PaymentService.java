package com.example.PaymentServiceSep24.Services;

import com.example.PaymentServiceSep24.paymentgateways.PaymentGateway;

import org.springframework.stereotype.Service;

import com.razorpay.RazorpayException;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String createPaymentLink(Long orderId) throws RazorpayException {
        //call the Razorpay/Stripe PG tp generate the payment link.

        return paymentGateway.createPaymentLink(orderId) ;
    }
}