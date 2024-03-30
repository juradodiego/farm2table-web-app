package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer cartId;
    private Integer farmId;
    private Integer customerId;
    private Integer farmerId;
    private Integer chatId;
    private String content;
}