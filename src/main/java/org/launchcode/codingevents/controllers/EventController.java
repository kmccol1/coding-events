package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("events")
public class EventController
{
    private static ArrayList<String> events = new ArrayList<>(); //non-persistent, exists in memory of program only.
    @GetMapping
    public String createList(Model model)
    {
        model.addAttribute("events",events);
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create route.
    public String renderCreateEventForm()
    {
        return "events/create";
    }

    @PostMapping("create") //lives at /events/create route.
    public String createEvent(@RequestParam String eventName) //parameter name must match the html element name for Spring Boot to work here.
    {
        events.add(eventName);
        return "redirect:/events"; //Returns redirect response 300 level HTTP response...
        // the /events IS needed for the redirect view to properly work or else 404 errors.
    }
}
