package com.ctrlaltdefeat.farmtotableconnect.model;

import lombok.*;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer messageId;
    private Integer chatId;
    private Integer senderId;
    private String content;
    private Timestamp sentAt;
}
