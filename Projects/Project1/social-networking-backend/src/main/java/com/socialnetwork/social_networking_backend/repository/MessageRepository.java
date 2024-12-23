package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByProfileId(Long profileId);

    Optional<Message> findByIdAndProfileId(Long messageId, Long profileId);
}
