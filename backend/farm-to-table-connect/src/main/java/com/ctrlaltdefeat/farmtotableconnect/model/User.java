package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer userId;
    private String username;
    private Integer farmId;
    private String addressLine;
    private String city;
    private String state;
    private int zipcode;
    private Boolean consumer;
    private String email;
    private Integer salt;
    private String password;
}
