package com.xworkz.eventapp;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.service.EventService;
import com.xworkz.eventapp.service.EventServiceImpl;

import java.util.Optional;
import java.util.Scanner;

public class EventRunner {

    public static void main(String[] args) {

        System.out.println("===== EVENT MANAGEMENT SYSTEM =====");

        EventService service = new EventServiceImpl();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\nChoose Operation:");
            System.out.println("1. Add Event");
            System.out.println("2. Get Event By ID");
            System.out.println("3. Delete Event");
            System.out.println("4. Update Event Time");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter choice: ");


            int choice = sc.nextInt();sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- ADD EVENT ---");

                    System.out.print("Enter Event Id: ");
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Enter Event Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Event Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter Event Manager: ");
                    String manager = sc.nextLine();

                    System.out.print("Enter Event Time: ");
                    String time = sc.nextLine();

                    EventDTO eventDTO =
                            new EventDTO(id, name, location, manager, time);

                    boolean saved = service.validateAndSave(eventDTO);
                    if (saved)
                        System.out.println("Event saved successfully");
                    else
                        System.out.println("Failed to save event");
                    break;

                case 2:
                    System.out.println("\n--- FETCH EVENT ---");

                    System.out.print("Enter Event Id: ");
                    int fetchId = sc.nextInt();

                    Optional<EventDTO> eventOpt = service.getById(fetchId);

                    if (eventOpt.isPresent()) {
                        EventDTO event = eventOpt.get();
                        System.out.println("\n===== Event Details =====");
                        System.out.println("Event ID       : " + event.getEventId());
                        System.out.println("Event Name     : " + event.getEventName());
                        System.out.println("Location       : " + event.getLocation());
                        System.out.println("Event Manager  : " + event.getEventManager());
                        System.out.println("Event Time     : " + event.getEventTime());
                        System.out.println("========================");
                    } else {
                        System.out.println("No event found for given ID");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DELETE EVENT ---");

                    System.out.print("Enter Event Id: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = service.deleteById(deleteId);
                    if (deleted)
                        System.out.println("Event deleted successfully");
                    else
                        System.out.println("Delete failed");
                    break;

                case 4:
                    System.out.println("\n--- UPDATE EVENT TIME ---");

                    System.out.print("Enter Event Id: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Updated Time: ");
                    String updatedTime = sc.nextLine();

                    boolean updated =
                            service.updateEventTimeById(updateId, updatedTime);

                    if (updated)
                        System.out.println("Event time updated successfully");
                    else
                        System.out.println("Update failed for id: " + updateId);
                    break;

                case 5:
                    running = false;
                    System.out.println("\nExiting Application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
        System.out.println("\n===== MAIN ENDED =====");
    }
}
