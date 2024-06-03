package org.launchcode.codingevents.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity
{
    @Column(name="Description")
    @Size(max = 500, message = "Description must not exceed 500 characters. Please try again.")
    private String description;
    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank.")
    private String location;

    public EventDetails(String description, String contactEmail, String location) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
    }

    public EventDetails() {
    }

    public String getDescription() {
        return description;
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
}
