package org.launchcode.codingevents.controllers;

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
    private static List<Event> events = new ArrayList<>();
    @GetMapping
    public String createList(Model model)
    {
//        events.put("Runtime exception", "An error occurred during execution.");
//        events.put("Load", "Program begins running.");
//        events.put("Quit", "Program quit running.");
//        events.put("Buffer overflow", "A program's memory capacity was exceeded.");
//        events.put("SQL Injection", "User input used to query the SQL DB.");
        events.add(new Event("Runtime exception"));
        events.add(new Event("Load"));
        events.add(new Event("Quit"));
        events.add(new Event("Buffer overflow"));
        events.add(new Event("SQL Injection"));
        model.addAttribute("events",events);
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
        events.add(new Event(eventName));
        return "redirect:/events"; //Returns redirect response 300 level HTTP response...
        // the /events IS needed for the redirect view to properly work or else 404 errors.
    }
}
