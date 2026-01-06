package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.entity.EventEntity;
import com.xworkz.eventapp.repository.EventRepository;
import com.xworkz.eventapp.repository.EventRepositoryImpl;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EventServiceImpl implements EventService{

    @Autowired
    private  EventRepository repo;

    @Override
    public boolean validateAndSave(EventDTO eventDTO) {

        boolean isSaved=false;

        boolean isValid=validateEvent(eventDTO);

        if(isValid) {
            EventEntity eventEntity = new EventEntity();
            BeanUtils.copyProperties(eventDTO, eventEntity);

            isSaved = repo.save(eventEntity);
            if (isSaved) System.out.println("Saved successfully");
            else System.err.println("Failed to save");
        }

        else System.err.println("Data entered is invalid");

        return isSaved;
    }

    @Override
    @SneakyThrows
    public Optional<EventDTO> getById(int id) {
        if(id>0) {
            Optional<EventEntity> eventEntity = repo.getById(id);


            if (eventEntity.isPresent()) {
                EventDTO eventDTO = new EventDTO();
                BeanUtils.copyProperties(eventEntity.get(), eventDTO);
                return Optional.of(eventDTO);
            } else {
                System.err.println("No result for given id found");
            }
        }
        return Optional.empty();
    }

    private boolean validateEvent(EventDTO dto) {

        if (dto == null) {
            System.err.println("Event object is null");
            return false;
        }
        else if (dto.getEventId() <= 0) {
            System.err.println("Event ID must be greater than 0");
            return false;
        }
        else if (dto.getEventName() == null || dto.getEventName().trim().isEmpty()) {
            System.err.println("Event name is invalid");
            return false;
        }
        else if (dto.getLocation() == null || dto.getLocation().trim().isEmpty()) {
            System.err.println("Event location is invalid");
            return false;
        }
        else if (dto.getEventManager() == null || dto.getEventManager().trim().isEmpty()) {
            System.err.println("Event manager name is invalid");
            return false;
        }
        else if (dto.getEventTime() == null || dto.getEventTime().trim().isEmpty()) {
            System.err.println("Event time is invalid");
            return false;
        }

        return true;
    }

}
