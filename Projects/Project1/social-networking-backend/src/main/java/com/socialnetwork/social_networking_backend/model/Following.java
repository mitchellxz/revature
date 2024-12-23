package com.socialnetwork.social_networking_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "following")
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follower_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_profile_id", nullable = false)
    @JsonBackReference("follower-profile")
    private Profile followerProfile;

    @ManyToOne
    @JoinColumn(name = "followed_profile_id", nullable = false)
    @JsonBackReference("followed-profile")
    private Profile followedProfile;

    @Column(name = "is_mutual", nullable = false)
    private boolean isMutual = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getFollowedProfile() {
        return followedProfile;
    }

    public void setFollowedProfile(Profile followedProfile) {
        this.followedProfile = followedProfile;
    }

    public Profile getFollowerProfile() {
        return followerProfile;
    }

    public void setFollowerProfile(Profile followerProfile) {
        this.followerProfile = followerProfile;
    }

    public boolean isMutual() {
        return isMutual;
    }

    public void setMutual(boolean mutual) {
        isMutual = mutual;
    }
}
