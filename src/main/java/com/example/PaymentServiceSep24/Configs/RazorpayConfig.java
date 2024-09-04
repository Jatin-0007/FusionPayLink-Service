package com.example.PaymentServiceSep24.Configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    @Value("${razorpay.key.id}")  // ----------|
    private String razorpayKeyID; //           |
    //                                         |---->  hiding key id and key secret in application properties using environment variables
    @Value("${razorpay.key.secret}")//         |
    private String razorpaySecret;//-----------|

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyID, razorpaySecret );
    }
}
