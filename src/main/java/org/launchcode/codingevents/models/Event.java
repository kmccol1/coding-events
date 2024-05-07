package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event
{
    private int id;
    private static int nextId = 1; //every obj shares same val...
    private String name;
    private String desc;

    public Event(String name, String aDesc)
    {
        this.name = name;
        this.desc = aDesc;
        this.id = nextId;
        nextId++;
    }

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
