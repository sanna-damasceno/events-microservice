package com.damasceno.events_microservice.controllers;



import com.damasceno.events_microservice.domain.Event;
import com.damasceno.events_microservice.dtos.EventRequestDTO;
import com.damasceno.events_microservice.dtos.SubscriptionRequestDTO;
import com.damasceno.events_microservice.exceptions.EventFullException;
import com.damasceno.events_microservice.exceptions.EventNotFoundException;
import com.damasceno.events_microservice.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventRequestDTO event) {
        return eventService.createEvent(event);
    }

    @PostMapping("/{eventId}/register")
    public ResponseEntity<String> registerParticipant(@PathVariable String eventId, @RequestBody SubscriptionRequestDTO subscriptionRequest) {
        eventService.registerParticipant(eventId, subscriptionRequest.participantEmail());
        return ResponseEntity.ok("Participant registered successfully");
    }
}