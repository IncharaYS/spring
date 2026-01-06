package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.entity.EventEntity;

import java.util.Optional;

public interface EventService {
    boolean validateAndSave(EventDTO eventDTO);
     Optional<EventDTO> getById(int id);
    boolean deleteById(int id);

    public boolean updateEventTimeById(int id,String time);
}
