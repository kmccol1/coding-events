package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    //Insert controller code here...
    @GetMapping()
    public String getName()
    {
        return "Hello, Spring!";
    }
}
