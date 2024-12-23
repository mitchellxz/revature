package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByPostIdAndProfileId(Long postId, Long profileId);

    List<Likes> findByPostId(Long postId);

    List<Likes> findByProfileId(Long profileId);
}
