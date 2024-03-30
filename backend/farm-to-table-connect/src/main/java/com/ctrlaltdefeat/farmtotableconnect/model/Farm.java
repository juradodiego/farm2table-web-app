package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer farmId;
    private String farmName;
    private Double latitude;
    private Double longitude;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> selling;
}
