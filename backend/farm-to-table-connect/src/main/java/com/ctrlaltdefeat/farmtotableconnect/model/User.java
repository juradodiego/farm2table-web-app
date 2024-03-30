package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer userId;
    private Farm farm;
    private Boolean consumer;
    private String email;
    private Integer salt;
    private String password;
}
