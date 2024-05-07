package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.springframework.stereotype.Controller;
import org.launchcode.codingevents.models.Event;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController
{
    //private static HashMap<String, String> events = new HashMap<>(); //non-persistent, exists in memory of program only.
    //private static List<Event> events = new ArrayList<>();
    @GetMapping
    public String createList(Model model)
    {
//        events.put("Runtime exception", "An error occurred during execution.");
//        events.put("Load", "Program begins running.");
//        events.put("Quit", "Program quit running.");
//        events.put("Buffer overflow", "A program's memory capacity was exceeded.");
//        events.put("SQL Injection", "User input used to query the SQL DB.");
        EventData.add(new Event("Runtime exception", "An error occurred during execution."));
        EventData.add(new Event("Load", "Program begins running."));
        EventData.add(new Event("Quit", "Program quit running."));
        EventData.add(new Event("Buffer overflow", "A program's memory capacity was exceeded."));
        EventData.add(new Event("SQL Injection", "User input used to query the SQL DB."));
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create route.
    public String renderCreateEventForm()
    {
        return "events/create";
    }

    @PostMapping("create") //lives at /events/create route.
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDesc) //parameter name must match the html element name for Spring Boot to work here.
    {
        //events.add(eventName);
        //events.put(eventName, eventDesc);
        EventData.add(new Event(eventName, eventDesc));
        return "redirect:/events"; //Returns redirect response 300 level HTTP response...
        // the /events IS needed for the redirect view to properly work or else 404 errors.
    }
}
