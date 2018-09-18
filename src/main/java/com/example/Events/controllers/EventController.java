package com.example.Events.controllers;

import com.example.Events.models.forms.CommentForm;
import com.example.Events.models.forms.EventForm;
import com.example.Events.models.services.CommentService;
import com.example.Events.models.services.EventService;
import com.example.Events.models.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    final EventService eventService;
    final SessionService sessionService;
    final CommentService commentService;



    @Autowired
    public EventController(EventService eventService, SessionService sessionService, CommentService commentService) {
        this.eventService = eventService;
        this.sessionService = sessionService;
        this.commentService = commentService;

    }



    @GetMapping("/event")
    public String post(Model model) {
        if(!sessionService.isLoggedIn()){
            return "redirect:/login";
        }
        model.addAttribute("eventForm", new EventForm());
        return "addEvent";
    }

    @PostMapping("/event")
    public String post(@ModelAttribute("postForm") EventForm eventForm){
        eventService.addEvent(eventForm);
        return "redirect:/";
    }


    @GetMapping("/event/{id}")
    public String post(@PathVariable("id") int id,
                       Model model){
//        model.addAttribute("eventData", eventService.getAllEventData(eventService.getAllPostData(id).getBlog().getId()));
        model.addAttribute("eventData",  eventService.getAllEventData(id));
        model.addAttribute("commentForm", new CommentForm());
        return "event";
    }

    @PostMapping("/comment/{id}")
    public String comment(@PathVariable("id") int id,
                          @ModelAttribute("commentForm") CommentForm comment){
        if(!sessionService.isLoggedIn()){
            return "redirect:/login";
        }
        commentService.addComment(comment, id);
        return "redirect:/event/" + id;
    }
}