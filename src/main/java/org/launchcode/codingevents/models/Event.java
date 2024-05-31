package org.launchcode.codingevents.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity
{

    //private static int nextId = 1; //every obj shares same val...
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name field must be between 3 and 50 characters in length. Please try again.")
    private String name;
    @Column(name="Description")
    @Size(max = 500, message = "Description must not exceed 500 characters. Please try again.")
    private String description;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank.")
    private String location;
//
//    //@Positive(message = "Registration can only be marked as true.")
//    private boolean mustRegister;
//
//    @Positive(message="Number of attendees must be one or more.")
//    private int numberOfAttendees;
//
//    @Future(message = "Event date must be in the future.")
//    private Date eventDate;

    private EventType type;

    public Event(String name, String aDesc, String email, String location, EventType aType)
    {
        //this();
        this.name = name;
        this.description = aDesc;
        this.contactEmail = email;
        this.location = location;
        this.type = aType;
    }

    public Event()
    {
        //this.id = nextId;
        //nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public boolean isMustRegister() {
//        return mustRegister;
//    }
//
//    public void setMustRegister(boolean mustRegister) {
//        this.mustRegister = mustRegister;
//    }
//
//    public int getNumberOfAttendees() {
//        return numberOfAttendees;
//    }
//
//    public void setNumberOfAttendees(int numberOfAttendees) {
//        this.numberOfAttendees = numberOfAttendees;
//    }
//
//    public Date getEventDate() {
//        return eventDate;
//    }
//
//    public void setEventDate(Date eventDate) {
//        this.eventDate = eventDate;
//    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }




}
