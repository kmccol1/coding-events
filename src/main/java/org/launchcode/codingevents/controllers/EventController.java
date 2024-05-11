package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.springframework.stereotype.Controller;
import org.launchcode.codingevents.models.Event;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
//        EventData.add(new Event("Runtime exception", "An error occurred during execution."));
//        EventData.add(new Event("Load", "Program begins running."));
//        EventData.add(new Event("Quit", "Program quit running."));
//        EventData.add(new Event("Buffer overflow", "A program's memory capacity was exceeded."));
//        EventData.add(new Event("SQL Injection", "User input used to query the SQL DB."));
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create route.
    public String renderCreateEventForm(Model model)
    {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping("create") //lives at /events/create route.
    //public String createEvent(@RequestParam String eventName, @RequestParam String eventDesc) //parameter name must match the html element name for Spring Boot to work here.
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model)
    {
        //events.add(eventName);
        //events.put(eventName, eventDesc);
        //EventData.add(new Event(eventName, eventDesc));
        String result;

        if(errors.hasErrors())
        {
            model.addAttribute("title", "Create Event");
            //model.addAttribute("errorMsg", "Bad data!");
            result = "events/create";
        }
        else
        {
            EventData.add(newEvent);
            result = "redirect:/events";
        }

        return result; //Returns redirect response 300 level HTTP response...
        // the /events IS needed for the redirect view to properly work or else 404 errors.
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model)
    {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) //we need to know the data type,
    // the ids are ints, all same name in the html,
    // can be int[] must be same as name attribute in the form element.
    {
        if(eventIds != null)
        {
            for (int id: eventIds)
            {
                EventData.remove(id);
            }
        }

        return "redirect:/events";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId)
    {
        Event myEvent;
        String title = "Edit Event ";

        myEvent = EventData.getById(eventId);

        model.addAttribute("event", myEvent);

        title += myEvent.getName() + " (id=" + myEvent.getId() + ")";

        model.addAttribute("title", title);

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String desc)
    {
        Event myEvent = EventData.getById(eventId);

        myEvent.setName(name);
        myEvent.setDesc(desc);

        return "redirect:/events";
    }
}
