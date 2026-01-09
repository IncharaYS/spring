package com.xworkz.eventapp;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.service.EventService;
import com.xworkz.eventapp.service.EventServiceImpl;
import com.xworkz.eventapp.util.EntityManagerFactoryUtil;

import java.util.List;
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
            System.out.println("4. Update Event Time By Name");
            System.out.println("5. Update Event Time");
            System.out.println("6. Get Event By Name");
            System.out.println("7. Get Event By Location");
            System.out.println("8. Get Event By Manager");
            System.out.println("9. Get Event By Time");
            System.out.println("10. Get Event Manager & Location By Event Name");
            System.out.println("11. View All Events");
            System.out.println("12. Get Locations By Event Time");
            System.out.println("13. Get Event Name By Manager");
            System.out.println("14. View All Event Managers");
            System.out.println("15. Exit");

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
                    System.out.println("\n--- UPDATE EVENT TIME BY NAME ---");

                    System.out.print("Enter Event Name: ");
                    String eventName = sc.nextLine();

                    System.out.print("Enter Updated Time: ");
                    String updatedTime = sc.nextLine();

                    boolean updated =
                            service.updateEventTimeByName(eventName, updatedTime);

                    if (updated)
                        System.out.println("Event time1 updated successfully");
                    else
                        System.out.println("Update failed for event name: " + eventName);
                    break;


                case 5:
                    System.out.println("\n--- UPDATE EVENT TIME ---");

                    System.out.print("Enter Event Id: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Updated Time: ");
                    String updatedTime1 = sc.nextLine();

                    boolean updated1 =
                            service.updateEventTimeById(updateId, updatedTime1);

                    if (updated1)
                        System.out.println("Event time1 updated1 successfully");
                    else
                        System.out.println("Update failed for id: " + updateId);
                    break;


                case 6:
                    System.out.println("\n--- FETCH EVENT BY NAME ---");

                    System.out.print("Enter Event Name: ");
                    String eventName1 = sc.nextLine();

                    Optional<EventDTO> eventByName = service.getEventByEventName(eventName1);

                    if (eventByName.isPresent()) {
                        EventDTO event = eventByName.get();
                        System.out.println("\n===== Event Details =====");
                        System.out.println("Event ID       : " + event.getEventId());
                        System.out.println("Event Name     : " + event.getEventName());
                        System.out.println("Location       : " + event.getLocation());
                        System.out.println("Event Manager  : " + event.getEventManager());
                        System.out.println("Event Time     : " + event.getEventTime());
                        System.out.println("========================");
                    } else {
                        System.out.println("No event found with name: " + eventName1);
                    }
                    break;

                case 7:
                    System.out.println("\n--- FETCH EVENT BY LOCATION ---");
                    System.out.print("Enter Event Location: ");
                    String location1 = sc.nextLine();

                    List<EventDTO> eventsByLocation =
                            service.getEventByEventLocation(location1);

                    if (!eventsByLocation.isEmpty()) {

                        System.out.println("\n===== Event Details =====");
                        eventsByLocation.forEach(event -> {
                            System.out.println("Event ID       : " + event.getEventId());
                            System.out.println("Event Name     : " + event.getEventName());
                            System.out.println("Location       : " + event.getLocation());
                            System.out.println("Event Manager  : " + event.getEventManager());
                            System.out.println("Event Time     : " + event.getEventTime());
                            System.out.println("------------------------");
                        });

                    } else {
                        System.out.println("No events found at location: " + location1);
                    }
                    break;

                case 8:
                    System.out.println("\n--- FETCH EVENT BY MANAGER ---");
                    System.out.print("Enter Event Manager: ");
                    String manager1 = sc.nextLine();

                    List<EventDTO> eventsByManager =
                            service.getEventByEventManager(manager1);

                    if (!eventsByManager.isEmpty()) {

                        System.out.println("\n===== Event Details =====");
                        eventsByManager.forEach(event -> {
                            System.out.println("Event ID       : " + event.getEventId());
                            System.out.println("Event Name     : " + event.getEventName());
                            System.out.println("Location       : " + event.getLocation());
                            System.out.println("Event Manager  : " + event.getEventManager());
                            System.out.println("Event Time     : " + event.getEventTime());
                            System.out.println("------------------------");
                        });

                    } else {
                        System.out.println("No events found managed by: " + manager1);
                    }
                    break;



                case 9:
                    System.out.println("\n--- FETCH EVENT BY TIME ---");
                    System.out.print("Enter Event Time: ");
                    String time1 = sc.nextLine();

                    List<EventDTO> eventsByTime =
                            service.getEventByEventTime(time1);

                    if (!eventsByTime.isEmpty()) {

                        System.out.println("\n===== Event Details =====");
                        eventsByTime.forEach(event -> {
                            System.out.println("Event ID       : " + event.getEventId());
                            System.out.println("Event Name     : " + event.getEventName());
                            System.out.println("Location       : " + event.getLocation());
                            System.out.println("Event Manager  : " + event.getEventManager());
                            System.out.println("Event Time     : " + event.getEventTime());
                            System.out.println("------------------------");
                        });

                    } else {
                        System.out.println("No events found at time: " + time1);
                    }
                    break;

                case 10:
                    System.out.println("\n--- FETCH EVENT MANAGER & LOCATION BY NAME ---");

                    System.out.print("Enter Event Name: ");
                    String eventName2 = sc.nextLine();

                    Object[] result = service.getManagerAndLocationByEventName(eventName2);

                    if (result != null && result.length == 2) {
                        System.out.println("\n===== Event Info =====");
                        System.out.println("Event Manager : " + result[0]);
                        System.out.println("Location      : " + result[1]);
                        System.out.println("======================");
                    } else {
                        System.out.println("No details found for event name: " + eventName2);
                    }
                    break;


                case 11:
                    System.out.println("\n--- ALL EVENTS ---");

                    List<EventDTO> events = service.getEvents();
                    if (events != null ) {
                        System.out.println("\n===== Event List =====");
                        for (EventDTO event : events) {
                            System.out.println("ID       : " + event.getEventId());
                            System.out.println("Name     : " + event.getEventName());
                            System.out.println("Location : " + event.getLocation());
                            System.out.println("Manager  : " + event.getEventManager());
                            System.out.println("Time     : " + event.getEventTime());
                            System.out.println("----------------------");
                        }
                    } else {
                        System.out.println("No events found");
                    }
                    break;


                case 12:
                    System.out.println("\n--- FETCH LOCATIONS BY EVENT TIME ---");

                    System.out.print("Enter Event Time: ");
                    String timeInput = sc.nextLine();

                    List<String> locations = service.getLocationByTime(timeInput);

                    if (!locations.isEmpty()) {
                        System.out.println("\n===== Locations =====");
                        locations.forEach(locationFetched ->
                                System.out.println(">" + locationFetched)
                        );
                        System.out.println("=====================");
                    } else {
                        System.out.println("No locations found for time: " + timeInput);
                    }
                    break;


                case 13:
                    System.out.println("\n--- FETCH EVENT NAME BY MANAGER ---");

                    System.out.print("Enter Event Manager Name: ");
                    String managerInput = sc.nextLine();

                    String eventName4 = service.getNameByManager(managerInput);

                    if (eventName4 != null) {
                        System.out.println("\n===== Event Name =====");
                        System.out.println("Event Name : " + eventName4);
                        System.out.println("======================");
                    } else {
                        System.out.println("No event found for manager: " + managerInput);
                    }
                    break;

                case 14:
                    System.out.println("\n--- ALL EVENT MANAGERS ---");

                    List<String> managers = service.getMangers();

                    if (!managers.isEmpty()) {
                        System.out.println("\n===== Managers =====");
                        managers.forEach(managerFetched ->
                                System.out.println(">" + managerFetched)
                        );
                        System.out.println("====================");
                    } else {
                        System.out.println("No managers available");
                    }
                    break;



                case 15:
                    running = false;
                    EntityManagerFactoryUtil.close();
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
