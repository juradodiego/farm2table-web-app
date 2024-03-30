package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer farmID;
    private String farmName;
    private Double latitude;
    private Double longitude;
}
