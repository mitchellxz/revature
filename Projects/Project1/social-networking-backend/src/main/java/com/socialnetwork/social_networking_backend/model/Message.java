package com.socialnetwork.social_networking_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

    @Column(name = "message_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageText;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference("post-messages")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonBackReference("profile-messages")
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Message() {

    }

    public Message(Profile profile, String messageText, LocalDateTime createdAt) {
        this.profile = profile;
        this.messageText = messageText;
        this.createdAt = createdAt;
    }

    public Message(Long id, Profile profile, String messageText, LocalDateTime createdAt) {
        this.id = id;
        this.profile = profile;
        this.messageText = messageText;
        this.createdAt = createdAt;
    }

}
