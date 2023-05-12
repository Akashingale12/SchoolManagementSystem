package com.schoolmanagementsystem.model.ui;

import lombok.Data;

import java.util.Date;

@Data
public class EventRequestDTO {

    private String eventName;
    private Date eventDate;
}
