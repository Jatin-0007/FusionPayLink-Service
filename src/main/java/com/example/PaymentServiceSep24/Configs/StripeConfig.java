package com.example.PaymentServiceSep24.Configs;

import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.key.id}")
    private String stripeKeyID;



    @Bean
    public StripeClient stripeClient() throws StripeException {
        // Initialize Stripe client
        return new StripeClient(stripeKeyID);
    }
}
