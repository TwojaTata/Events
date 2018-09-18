package com.example.Events.models.repositories;

import com.example.Events.models.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {
    List<EventEntity> findAllByOrderByIdDesc();
}
