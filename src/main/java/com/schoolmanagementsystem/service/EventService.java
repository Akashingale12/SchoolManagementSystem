package com.schoolmanagementsystem.service;

import com.schoolmanagementsystem.model.Event;
import com.schoolmanagementsystem.model.ui.EventRequestDTO;
import com.schoolmanagementsystem.model.ui.EventResponseDTO;
import com.schoolmanagementsystem.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EventResponseDTO addEvent(EventRequestDTO eventRequestDTO){
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        Event event = modelMapper.map(eventRequestDTO, Event.class);
        Event savedEvent =  eventRepository.save(event);
        eventResponseDTO = modelMapper.map(savedEvent,EventResponseDTO.class);
        return eventResponseDTO;
    }

    public EventResponseDTO updateEvent(long eventId,EventRequestDTO eventRequestDTO){
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        Optional<Event> event = eventRepository.findById(eventId);
        if(event.isPresent()){
                event.get().setEventName(eventRequestDTO.getEventName());
                event.get().setEventDate(eventRequestDTO.getEventDate());
                event.get().setId(eventId);
               Event updateEvent = eventRepository.save(event.get());
               eventResponseDTO = modelMapper.map(updateEvent, EventResponseDTO.class);
        }else{

        }
        return eventResponseDTO;
    }
}
