package com.musicHub.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired annotation
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.musicHub.entities.Users;
import com.musicHub.servicies.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

    @Autowired // Autowire UserService bean
    UserService userService;

    @PostMapping("/createOrder")
    @ResponseBody
    public String createOrder() {
        Order order = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_jB2axCZ0QuiqCJ", "8aGQGsYH3Jmys6SQBA15fw7f");

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", 5000);
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "receipt#1");
            JSONObject notes = new JSONObject();
            notes.put("notes_key_1", "Tea, Earl Grey, Hot");
            orderRequest.put("notes", notes);

            order = razorpay.orders.create(orderRequest);
        } catch (Exception e) {
            System.out.println("Exception while creating order: " + e);
        }
        return order.toString();
    }

    @PostMapping("/verify")
    @ResponseBody
    public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId,
            @RequestParam String signature) {
        try {
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_jB2axCZ0QuiqCJ", "8aGQGsYH3Jmys6SQBA15fw7f");
            String verificationData = orderId + "|" + paymentId;

            boolean isValidSignature = Utils.verifySignature(verificationData, signature, "8aGQGsYH3Jmys6SQBA15fw7f");

            return isValidSignature;
        } catch (RazorpayException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Payment success
    @GetMapping("payment-success")
    public String paymentSuccess(HttpSession session) {
        String email = (String) session.getAttribute("email");
        Users user = userService.getUser(email);
        user.setPremium(true);
        userService.updateUser(user);

        return "login";
    }

    // Payment failure
    @GetMapping("payment-failure")
    public String paymentFailure() {
        return "login";
    }
}
