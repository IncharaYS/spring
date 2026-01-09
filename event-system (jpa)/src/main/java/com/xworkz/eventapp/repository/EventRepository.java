package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.entity.EventEntity;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    boolean save(EventEntity eventEntity);

    Optional<EventEntity> getById(int id);

    boolean deleteById(int id);

     boolean updateEventTimeById(int id,String time);

    Optional<EventEntity> getEventByEventName(String eventName);

    boolean updateEventTimeByName(String eventName,String time);

    List<EventEntity> getEvents();

    List<EventEntity> getEventByEventLocation(String eventLocation);

    List<EventEntity> getEventByEventManager(String eventManager);

    List<EventEntity> getEventByEventTime(String eventTime);

    Object[]  getManagerAndLocationByEventName(String eventName);

    List<String> getLocationByTime(String time);

    String getNameByManager(String manager);

    List<String> getMangers();

}
