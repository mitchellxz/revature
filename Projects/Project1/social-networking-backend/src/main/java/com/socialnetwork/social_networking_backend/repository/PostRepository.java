package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByIdAndProfileId(Long postId, Long profileId);

    List<Post> findByProfileId(Long profileId);

    List<Post> findByProfileIn(List<Profile> followedProfiles);
}
