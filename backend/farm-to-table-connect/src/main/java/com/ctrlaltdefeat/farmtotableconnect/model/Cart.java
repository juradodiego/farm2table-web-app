package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import java.util.List;

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
    private Integer customerId;
    private Integer farmerId;
    private Boolean approvedByFarmer;
    private Boolean approvedByCustomer;
    private Boolean isActive;
    @Column
    @ElementCollection(targetClass=CartItem.class)
    private List<CartItem> content;
}
