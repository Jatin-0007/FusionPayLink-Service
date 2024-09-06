package com.example.PaymentServiceSep24.paymentgateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {

   String createPaymentLink(Long orderID) throws RazorpayException, StripeException;
}
