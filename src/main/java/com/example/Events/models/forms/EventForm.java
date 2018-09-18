package com.example.Events.models.forms;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class EventForm {
    private String title;
    private String description;
    private Date date;
    private String place;
}
