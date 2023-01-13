package com.example.demo.sweater.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="messge")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private String teg;

    public Message(String text, String teg) {
        this.text = text;
        this.teg = teg;
    }
}
