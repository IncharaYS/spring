package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.entity.EventEntity;

import java.util.Optional;

public interface EventService {
    boolean validateAndSave(EventDTO eventDTO);
    public Optional<EventDTO> getById(int id);
}
