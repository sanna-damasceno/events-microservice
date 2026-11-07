package com.damasceno.events_microservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.damasceno.events_microservice.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
