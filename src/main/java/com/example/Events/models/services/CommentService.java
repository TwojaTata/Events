package com.example.Events.models.services;

import com.example.Events.models.entities.CommentEntity;
import com.example.Events.models.entities.EventEntity;
import com.example.Events.models.entities.UserEntity;
import com.example.Events.models.forms.CommentForm;
import com.example.Events.models.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    final CommentRepository commentRepository;
    final SessionService sessionService;

    @Autowired
    public CommentService(CommentRepository commentRepository, SessionService sessionService) {
        this.commentRepository = commentRepository;
        this.sessionService = sessionService;
    }

    public void addComment(CommentForm commentForm, int postId){
        CommentEntity commentEntity = createCommentEntity(commentForm, postId);
        commentRepository.save(commentEntity);
    }

    private CommentEntity createCommentEntity(CommentForm commentForm, int eventId) {
        CommentEntity commentEntity = new CommentEntity();
        EventEntity eventEntity = new EventEntity();
        UserEntity userEntity = new UserEntity();

        eventEntity.setId(eventId);
        userEntity.setId(sessionService.getUserEntity().getId());

        commentEntity.setContext(commentForm.getContext());
        commentEntity.setEvent(eventEntity);
        commentEntity.setUser(userEntity);
        return commentEntity;
    }
}
