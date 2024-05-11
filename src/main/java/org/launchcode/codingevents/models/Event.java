package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event
{
    private int id;
    private static int nextId = 1; //every obj shares same val...
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name field must be between 3 and 50 characters in length. Please try again.")
    private String name;
    @Size(max = 500, message = "Description must not exceed 500 characters. Please try again.")
    private String desc;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    public Event(String name, String aDesc, String email)
    {
        this.name = name;
        this.desc = aDesc;
        this.contactEmail = email;
        this.id = nextId;
        nextId++;
    }

    public Event(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
