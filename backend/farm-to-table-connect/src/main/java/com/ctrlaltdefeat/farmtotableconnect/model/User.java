package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GeenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer user_id;
    private String username;
    private Integer farm_id;
    private String address_line;
    private String city;
    private String state;
    private int zipcode;
    private Boolean consumer;
    private String email;
    private Integer salt;
    private String password;
}
