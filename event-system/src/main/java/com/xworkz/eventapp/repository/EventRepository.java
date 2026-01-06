package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.entity.EventEntity;

import java.util.Optional;

public interface EventRepository {
    boolean save(EventEntity eventEntity);

    Optional<EventEntity> getById(int id);
}
