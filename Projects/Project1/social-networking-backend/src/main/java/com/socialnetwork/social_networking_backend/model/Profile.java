package com.socialnetwork.social_networking_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profile {
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "account", nullable = false)
    private Account account;

    @JsonManagedReference("profile-posts")
    @OneToMany(mappedBy = "profile")
    private List<Post> posts;

    @JsonManagedReference("profile-likes")
    @OneToMany(mappedBy = "profile")
    private List<Likes> likes;

    @JsonManagedReference("profile-messages")
    @OneToMany(mappedBy = "profile")
    private List<Message> messages;

    @JsonManagedReference("follower-profile")
    @OneToMany(mappedBy = "followerProfile")
    private List<Following> followings;

    @Column(name = "full_name")
    private String fullName;

    private String bio;

    private String profilePicture;

    private String location;

    public Profile() {

    }

    public Profile(Account account) {
        this.account = account;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
