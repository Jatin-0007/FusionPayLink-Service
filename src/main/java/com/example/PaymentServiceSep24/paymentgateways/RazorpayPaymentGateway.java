package com.example.PaymentServiceSep24.paymentgateways;

import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.razorpay.RazorpayClient;
import com.razorpay.PaymentLink;

@Component //need object of this class

public class RazorpayPaymentGateway implements PaymentGateway {

    private RazorpayClient razorpay;

    RazorpayPaymentGateway(RazorpayClient razorpay) {
        this.razorpay = razorpay;

    }

    @Override
    public String createPaymentLink(Long orderID) throws RazorpayException {



        JSONObject paymentLinkRequest = new JSONObject();

        paymentLinkRequest.put("amount",1000); // 1000 = 10.00 last two digits are considered as after decimal values in every platform not only in razorpay
        paymentLinkRequest.put("currency","INR");
       // paymentLinkRequest.put("accept_partial",true);
     //   paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1725580690); // time to pay in this limit Epoch timestamp format
        paymentLinkRequest.put("reference_id",orderID.toString());
        paymentLinkRequest.put("description","Payment for order id: "+orderID.toString());
        JSONObject customer = new JSONObject();
        customer.put("name","+917985091355");
        customer.put("contact","Jatin Singh");
        customer.put("email","jatinsingh1718@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Scaler");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/mentee-dashboard/todos"); // redirect when payment succesfull to this url
        paymentLinkRequest.put("callback_method","get");


        PaymentLink payment = null;
        try {
             payment = razorpay.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RazorpayException(e);
        }



        return payment.toString();


    }
}
