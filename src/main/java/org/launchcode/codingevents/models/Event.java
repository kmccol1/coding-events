package org.launchcode.codingevents.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity
{
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
    @ManyToOne
    @NotNull(message = "Category field is required! Please try again.")
    private EventCategory eventCategory;

    public Event(String name, String aDesc, String email, String location, EventCategory category)
    {
        //this();
        this.name = name;
        this.description = aDesc;
        this.contactEmail = email;
        this.location = location;
        //this.type = aType;
        this.eventCategory = category;
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

}
