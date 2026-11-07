package com.damasceno.events_microservice.repositories;

import com.damasceno.events_microservice.domain.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    List<Event> findByDateAfterOrderByDate(LocalDateTime now);
}