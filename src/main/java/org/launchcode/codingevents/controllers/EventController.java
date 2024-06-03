package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepositoryDAO;
import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.Tag;
import org.launchcode.codingevents.models.dto.EventTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.launchcode.codingevents.models.Event;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController
{
    @Autowired
    private EventRepositoryDAO eventRepository;
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String createList(@RequestParam(required = false) Integer categoryId, Model model)
    {
        //To use the categoryId @RequestParam...'/events?categoryId=<categoryId>'
        if(categoryId == null)
        {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        }
        else
        {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if(result.isEmpty())
            {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            }
            else
            {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in Category: " + category.getName());
                model.addAttribute("events", category.getEvents());
            }
        }

        return "events/index";
    }

    @GetMapping("create") //lives at /events/create route.
    public String renderCreateEventForm(Model model)
    {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "events/create";
    }

    @PostMapping("create") //lives at /events/create route.
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model)
    {
        if(errors.hasErrors())
        {
            //model.addAttribute("errors", errors.getAllErrors());
            //model.addAttribute("types", EventType.values());
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model)
    {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
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
                //EventData.remove(id);
                eventRepository.deleteById(id);
            }
        }

        return "redirect:/events";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId)
    {
        Event myEvent = new Event();
        String title = "Edit Event ";
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent())
        {
            Event foundEvent = eventOptional.get();
            model.addAttribute("event", foundEvent);
            title += eventOptional.get().getName() + " (id=" + eventOptional.get().getId() + ")";
        }

        model.addAttribute("title", title);

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(Model model, @RequestParam int eventId, @RequestParam String name, @RequestParam String description, @RequestParam String contactEmail, @RequestParam String location)
    {
        Event myEvent = new Event();
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent())
        {
            Event foundEvent = eventOptional.get();
            myEvent.setName(name);
            myEvent.getEventDetails().setDescription(description);
            myEvent.getEventDetails().setContactEmail(contactEmail);
            myEvent.setEventCategory(foundEvent.getEventCategory());
            myEvent.getEventDetails().setLocation(location);
            eventRepository.deleteById(eventId);
            eventRepository.save(myEvent);
        }

        return "redirect:/events";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model) {

        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }

        return "events/detail";
    }

    //responds to /events/add-tag?eventId=<event_id>
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);
        Event event = result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO eventTag = new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag", eventTag);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTag(@ModelAttribute @Valid EventTagDTO eventTag, Errors errors, Model model)
    {
        if(!errors.hasErrors())
        {
            Event event = eventTag.getEvent();
            Tag tag = eventTag.getTag();
            if(!event.getTags().contains(tag))
            {
                event.addTag(tag);
                eventRepository.save(event);
            }
            return "redirect:detail?eventId=" + event.getId();

        }
        return "redirect:add-tag";
    }
}
