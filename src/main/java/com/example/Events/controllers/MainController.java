package com.example.Events.controllers;


import com.example.Events.models.services.EventService;
import com.example.Events.models.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    final SessionService sessionService;
    final EventService eventService;

    public MainController(SessionService sessionService, EventService eventService) {
        this.sessionService = sessionService;
        this.eventService = eventService;
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userObject", sessionService);
        model.addAttribute("events", eventService.getAllEvents());

        return "index";
    }
}
