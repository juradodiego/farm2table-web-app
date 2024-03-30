package com.ctrlaltdefeat.farmtotableconnect.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CartItem {
    Integer produceId;
    Integer quantity;
    Double price;

}
