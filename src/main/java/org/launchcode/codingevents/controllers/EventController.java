package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("events")
public class EventController
{
    //Insert controller code here...
    @GetMapping()
    public String createList(Model model)
    {
        ArrayList<String> eventList = new ArrayList<>();
        eventList.add("Runtime exception");
        eventList.add("Logic error");
        eventList.add("Compile time exception");
        eventList.add("Buffer overflow");
        eventList.add("Cross site request forgery");

        model.addAttribute("eventList",eventList);

        return "events/index";
    }
}
