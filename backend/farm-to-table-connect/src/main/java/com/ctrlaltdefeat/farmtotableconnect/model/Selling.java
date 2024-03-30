package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Selling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer produceId;
    private Integer farmerId;
}
