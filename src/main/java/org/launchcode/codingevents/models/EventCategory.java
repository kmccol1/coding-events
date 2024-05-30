package org.launchcode.codingevents.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class EventCategory
{
    @Id
    @SequenceGenerator(name="event_category_seq", sequenceName = "event_category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_category_seq")
    private int id;
    @Size(min=3, message = "Name must be at least 3 characters long")
    private String name;

    public EventCategory(@Size(min=3, message = "Name must be at least 3 characters long") String name)
    {
        this.name = name;
    }

    public EventCategory()
    {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventCategory that = (EventCategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
