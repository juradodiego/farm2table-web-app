package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
    private Integer farmId;
    private String addressLine;
    private String city;
    private String state;
    private Integer zipcode;
    private Boolean consumer;
    private String email;
    private Integer salt;
    private String password;
}
