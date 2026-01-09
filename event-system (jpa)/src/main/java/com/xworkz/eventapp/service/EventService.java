package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dto.EventDTO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    boolean validateAndSave(EventDTO eventDTO);
     Optional<EventDTO> getById(int id);
    boolean deleteById(int id);

    boolean updateEventTimeById(int id,String time);

    Optional<EventDTO> getEventByEventName(String eventName);

    boolean updateEventTimeByName(String eventName,String time);

    List<EventDTO> getEvents();

    List<EventDTO>getEventByEventLocation(String eventLocation);

    List<EventDTO> getEventByEventManager(String eventManager);

    List<EventDTO> getEventByEventTime(String eventTime);

    Object[] getManagerAndLocationByEventName(String eventName);

    List<String> getLocationByTime(String time);

    String getNameByManager(String manager);

    List<String> getMangers();


}
