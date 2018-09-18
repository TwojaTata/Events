package com.example.Events.models.repositories;

import com.example.Events.models.entities.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository <CommentEntity, Integer> {

}
