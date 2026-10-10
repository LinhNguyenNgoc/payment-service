package com.example.payment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentReference;
    private Long orderId;
    private Double amount;
    private String paymentMethod; // VD: CREDIT_CARD, PAYPAL, BANK_TRANSFER
    private String status;        // VD: SUCCESS, PENDING, FAILED
}