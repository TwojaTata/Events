package com.example.Events.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String context;


    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name = "event_id")
    @ManyToOne
    private EventEntity event;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}

