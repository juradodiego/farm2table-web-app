package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer chatId;
    private Integer customerId;
    private Integer farmerId;
    @Column
    @ElementCollection(targetClass=Message.class)
    private List<Message> conversation;
}
