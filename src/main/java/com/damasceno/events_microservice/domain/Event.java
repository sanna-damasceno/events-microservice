package com.damasceno.events_microservice.domain;

import java.time.LocalDateTime;

import com.damasceno.events_microservice.dtos.EventRequestDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="event")
@Table(name="event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int maxParticipants;
    private int registeredParticipants;
    private LocalDateTime date;
    private String title;
    private String description;

    public Event(EventRequestDTO eventRequestDTO){
        this.date = eventRequestDTO.date();
        this.maxParticipants = eventRequestDTO.maxParticipants();
        this.registeredParticipants = eventRequestDTO.registeredParticipants();
        this.title = eventRequestDTO.title();
        this.description = eventRequestDTO.description();
    }
}