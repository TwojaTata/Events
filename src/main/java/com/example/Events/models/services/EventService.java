package com.example.Events.models.services;

import com.example.Events.models.entities.EventEntity;
import com.example.Events.models.forms.EventForm;
import com.example.Events.models.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final SessionService sessionService;
    private final EventRepository eventRepository;


    @Autowired
    public EventService(SessionService sessionService, EventRepository eventRepository) {
        this.sessionService = sessionService;
        this.eventRepository = eventRepository;

    }

    public void addEvent(EventForm eventForm){
        EventEntity postEntity = createEntityFromForm(eventForm);
        eventRepository.save(postEntity);
    }

    private EventEntity createEntityFromForm(EventForm eventForm) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setTitle(eventForm.getTitle());
        eventEntity.setDescription(eventForm.getDescription());
        eventEntity.setUser(sessionService.getUserEntity());
        eventEntity.setDate(eventForm.getDate());

        return eventEntity;
    }

    public Iterable<EventEntity> getAllEvents() { return eventRepository.findAllByOrderByIdDesc();
    }

    public EventEntity getAllEventData(int id) {
        return eventRepository.findById(id).get();
    }
}
