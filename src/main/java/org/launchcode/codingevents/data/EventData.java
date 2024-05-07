package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    //need a place to put events, get all events, get a single event, add an event, remove/delete an event
    private static final Map<Integer, Event> eventMap = new HashMap<>(); //data inside can change if final, not map itself...

    public static void add(Event anEvent)
    {
        eventMap.put(anEvent.getId(), anEvent);
    }

    public static Event getById(int id)
    {
        return eventMap.get(id);
    }

    public static Collection<Event> getAll()
    {
        return eventMap.values();
    }

    public static void remove(int id)
    {
        eventMap.remove(id);
    }
}
