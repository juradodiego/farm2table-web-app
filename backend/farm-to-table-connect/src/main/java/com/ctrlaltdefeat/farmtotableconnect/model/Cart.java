package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import java.security.Timestamp;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer cartID;
    private Integer farmID;
    private Integer customerID;
    private Integer farmerID;
    private Integer chatID;
    private String content;
    private Timestamp sentAt;
}
