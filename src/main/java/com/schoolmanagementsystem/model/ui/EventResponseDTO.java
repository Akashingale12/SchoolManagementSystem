package com.schoolmanagementsystem.model.ui;

import lombok.Data;

import java.util.Date;

@Data
public class EventResponseDTO {

    private long id;
    private String eventName;
    private Date eventDate;
}
