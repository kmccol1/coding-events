package org.launchcode.codingevents.models;

public class Event
{
    private String name;
    private String desc;

    public Event(String name, String aDesc)
    {
        this.name = name;
        this.desc = aDesc;
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

    @Override
    public String toString()
    {
        return this.getName();
    }
}
