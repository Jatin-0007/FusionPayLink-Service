package com.example.PaymentServiceSep24.paymentgateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {

   String createPaymentLink(Long orderID) throws RazorpayException;
}
