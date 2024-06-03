package org.launchcode.codingevents.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity
{
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name field must be between 3 and 50 characters in length. Please try again.")
    private String name;
    @ManyToOne
    @NotNull(message = "Category field is required! Please try again.")
    private EventCategory eventCategory;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;
//
//    //@Positive(message = "Registration can only be marked as true.")
//    private boolean mustRegister;
//
//    @Positive(message="Number of attendees must be one or more.")
//    private int numberOfAttendees;
//
//    @Future(message = "Event date must be in the future.")
//    private Date eventDate;

    //private EventType type;

//    CONFERENCE("Conference"),
//    MEETUP("Meetup"),
//    WORKSHOP("Workshop"),
//    SOCIAL("Social"),
//    SEMINAR("Seminar"),
//    GALA("Gala"),
//    DISCUSSION("Discussion"),
//    MEETING("Meeting"),
//    ROUNDTABLE("Roundtable"),
//    ALLHANDS("Allhands"),
//    CONVERSATION("Conversation"),
//    LECTURE("Lecture"),
//    BALL("Ball"),
//    FIESTA("Fiesta"),
//    FESTIVAL("Festival"),
//    SESSION("Session"),
//    STANDUP("Standup"),
//    DEBRIEF("Debrief"),
//    CONVENTION("Convention"),
//    CLASS("Class"),
//    GATHERING("Gathering"),
//    FORUM("Forum"),
//    ASSEMBLY("Assembly"),
//    CAUCUS("Caucus"),
//    PARTY("Party"),
//    FUNCTION("Function"),
//    JAMBOREE("Jamboree"),
//    REUNION("Reunion"),
//    GAME("Game"),
//    CELEBRATION("Celebration"),
//    MOVEMENT("Movement");

    public Event(String name, EventCategory category)
    {
        this.name = name;
        this.eventCategory = category;
    }

    public Event()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
    @Override
    public String toString()
    {
        return this.getName();
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }
}
