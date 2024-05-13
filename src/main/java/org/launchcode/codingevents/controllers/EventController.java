package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.launchcode.codingevents.models.Event;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController
{
    @GetMapping
    public String createList(Model model)
    {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create") //lives at /events/create route.
    public String renderCreateEventForm(Model model)
    {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create") //lives at /events/create route.
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model)
    {
//        String result;
//
//        if(errors.hasErrors())
//        {
//            model.addAttribute("title", "Create Event");
//            //model.addAttribute(new Event());
//            model.addAttribute("types", EventType.values());
//            result = "events/create";
//        }
//        else
//        {
//            EventData.add(newEvent);
//            result = "redirect:/events";
//        }
//
//        return result; //Returns redirect response 300 level HTTP response...
//        // the /events IS needed for the redirect view to properly work or else 404 errors.
//        if(errors.hasErrors()) {
//            model.addAttribute("types", EventType.values());
//            model.addAttribute("title", "Create Event");
//            return "events/create";
//        }
        //error is above in the if....

        if(errors.hasErrors())
        {
            //model.addAttribute("errors", errors.getAllErrors());
            //model.addAttribute("types", EventType.values());
            return "events/create";
        }
        else
        {
            EventData.add(newEvent);
            return "redirect:/events";
        }
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
