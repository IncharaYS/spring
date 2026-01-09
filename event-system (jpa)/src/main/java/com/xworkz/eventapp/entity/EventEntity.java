package com.xworkz.eventapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
@NamedQueries({
        @NamedQuery(name="getEventByEventName" ,query="select fetchedEntity from EventEntity fetchedEntity where fetchedEntity.eventName=:eName"),
        @NamedQuery(name="getEvents" ,query="from EventEntity"),
        @NamedQuery(name="deleteById" ,query="delete EventEntity e where e.eventId=:eId"),
        @NamedQuery(name = "updateEventTimeById",query = "update EventEntity e set e.eventTime=:eTime where e.eventId=:eId"),
        @NamedQuery(name = "updateEventTimeByName" ,query="from EventEntity fetchedEntity where fetchedEntity.eventName=:eName"),
        @NamedQuery(name = "getEventByEventLocation",query = "select e from EventEntity e where e.location=:eLocation"),
        @NamedQuery(name = "getEventByEventManager",query = "select e from EventEntity e where e.eventManager=:eManager"),
        @NamedQuery(name = "getEventByEventTime",query = "select e from EventEntity e where e.eventTime=:eTime"),
        @NamedQuery(name = "getManagerAndLocationByEventName",query = "select e.eventManager,e.location from EventEntity e where e.eventName=:eName"),
        @NamedQuery(name = "getLocationByTime",query = "select e.location from EventEntity e where e.eventTime=:eTime"),
        @NamedQuery(name = "getNameByManager",query = "select e.eventName from EventEntity e where e.eventManager=:eManager"),
        @NamedQuery(name = "getMangers",query = "select e.eventManager from EventEntity e"),
        @NamedQuery(name = "getById",query = "from EventEntity e where e.eventId=:eId")
})
public class EventEntity {

    @Id
    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_location")
    private String location;

    @Column(name = "event_manager")
    private String eventManager;

    @Column(name = "event_time")
    private String eventTime;
}
