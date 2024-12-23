package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByAccount_Id(Long accountId);

    Optional<Profile> findByAccount_Username(String username);

    @Query(value = "select * from profile\n" +
            "right join following\n" +
            "on following.followed_profile_id = profile.profile_id\n" +
            "where following.follower_profile_id = :followerProfileId;", nativeQuery = true)
    List<Profile> findFollowedProfiles(@Param("followerProfileId") Long followerProfileId);
}
