package com.example.Events.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String title;
    private String description;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    private Date date;

    @OneToMany (mappedBy = "event")
    private List<CommentEntity> comments;
}

