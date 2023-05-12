package com.schoolmanagementsystem.controller;

import com.schoolmanagementsystem.model.ui.EventRequestDTO;
import com.schoolmanagementsystem.model.ui.EventResponseDTO;
import com.schoolmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.POST, path = "/addevent")
    public EventResponseDTO addEvent(@RequestBody EventRequestDTO eventRequestDTO){
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        eventResponseDTO = eventService.addEvent(eventRequestDTO);
        return eventResponseDTO;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateevent/{eventId}")
    public EventResponseDTO updateEvent(@RequestParam long eventId, @RequestBody EventRequestDTO eventRequestDTO){
        EventResponseDTO eventResponseDTO = eventService.updateEvent(eventId,eventRequestDTO);
        return eventResponseDTO;
    }
}
