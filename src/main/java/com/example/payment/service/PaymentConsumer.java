package com.example.payment.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void handleOrderCreated(String message) {
        // Xử lý logic thanh toán giả lập thành công
        boolean paymentSuccess = true; 
        if (paymentSuccess) {
            // Bắn tiếp sự kiện sang topic "payment-events" cho Inventory
            kafkaTemplate.send("payment-events", message);
        }
    }
}