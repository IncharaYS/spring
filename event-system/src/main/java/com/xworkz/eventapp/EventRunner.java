package com.xworkz.eventapp;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.service.EventService;
import com.xworkz.eventapp.service.EventServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class EventRunner {
    public static void main(String[] args) {

        EventService service=new EventServiceImpl();

        Scanner sc=new Scanner(System.in);

//        System.out.print("Enter the event Id:");
//        int id=sc.nextInt();
//
//        System.out.print("Enter the event Name:");
//        String name=sc.next();
//
//        System.out.print("Enter the event location:");
//        String location=sc.next();
//
//        System.out.print("Enter the event Manager:");
//        String eventManager=sc.next();
//
//        System.out.print("Enter the event time:");
//        String time=sc.next();
//
//
//        EventDTO eventDTO=new EventDTO(id,name,location,eventManager,time);
//
//        boolean success=service.validateAndSave(eventDTO);
//        if (success) System.out.println("Validated and saved successfully");
//        else System.err.println("Failed to validate and save");

        System.out.print("Enter id to fetch event info: ");
        int idToFetch = sc.nextInt();

        Optional<EventDTO> eventDTO1 = service.getById(idToFetch);

        if (eventDTO1.isPresent()) {
            EventDTO event = eventDTO1.get();

            System.out.println("\n===== Event Details =====");
            System.out.println("Event ID       : " + event.getEventId());
            System.out.println("Event Name     : " + event.getEventName());
            System.out.println("Location       : " + event.getLocation());
            System.out.println("Event Manager  : " + event.getEventManager());
            System.out.println("Event Time     : " + event.getEventTime());
            System.out.println("=========================");
        } else {
            System.err.println("No event found for given ID");
        }

    }
}
