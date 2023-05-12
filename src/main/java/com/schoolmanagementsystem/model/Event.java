package com.schoolmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private Date eventDate;
}
