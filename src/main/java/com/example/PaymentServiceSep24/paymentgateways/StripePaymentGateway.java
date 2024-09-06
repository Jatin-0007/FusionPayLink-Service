package com.example.PaymentServiceSep24.paymentgateways;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripePaymentGateway implements PaymentGateway{

   private StripeClient stripe;

    StripePaymentGateway(StripeClient stripe) {
        this.stripe = stripe;
    }

    @Override
    public String createPaymentLink(Long orderID) throws StripeException {




        try {
            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice("price_1Pw1QlRuIb0EUeTWq5IhaWHf")
                                            .setQuantity(1L)
                                            .build()
                            )
                            .setAfterCompletion(
                                    PaymentLinkCreateParams.AfterCompletion.builder()
                                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                    .setRedirect(
                                            PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                    .setUrl("https://www.scaler.com/academy/mentee-dashboard/todos")
                                                    .build()
                                    )
                                    .build()

                            )
                            .build();

            PaymentLink paymentLink = stripe.paymentLinks().create(params);

            return paymentLink.getUrl();

        } catch (StripeException e) {

                  e.printStackTrace();
                    return "error"+ e.getMessage();


        }
    }
}
