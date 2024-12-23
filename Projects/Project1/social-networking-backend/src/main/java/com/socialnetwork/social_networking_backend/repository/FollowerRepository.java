package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowerRepository extends JpaRepository<Following, Long> {
    List<Following> findByFollowedProfileId(Long followedProfileId);

    Optional<Following> findByFollowerProfileIdAndFollowedProfileId(Long followerProfileId, Long followedProfileId);

    List<Following> findByFollowerProfileId(Long profileId);


}
