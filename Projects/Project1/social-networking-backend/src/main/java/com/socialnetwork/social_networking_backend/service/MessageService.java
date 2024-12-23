package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Message;
import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.MessageRepository;
import com.socialnetwork.social_networking_backend.repository.PostRepository;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ProfileRepository profileRepository;
    private final PostRepository postRepository;

    public MessageService(MessageRepository messageRepository, ProfileRepository profileRepository, PostRepository postRepository) {
        this.messageRepository = messageRepository;
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
    }

    public Message createMessage(Long profileId, Long postId, Message message) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow( () -> new IllegalArgumentException("Profile not found with ID " + profileId));

        Post post = postRepository.findById(postId)
                        .orElseThrow( () -> new IllegalArgumentException("Post not found with ID " + postId));

        message.setProfile(profile);
        message.setPost(post);


        // need to create edge cases for null or "" messages


        if (message.getCreatedAt() == null) {
            message.setCreatedAt(LocalDateTime.now());
        }
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long profileId, Long messageId) {
        Optional<Message> optionalMessage = messageRepository.findByIdAndProfileId(messageId, profileId);
        if (optionalMessage.isEmpty()) {
            throw new IllegalArgumentException("No message to display.");
        }
        return optionalMessage.get();
    }

    public List<Message> getAllMessagesByProfileId(Long profileId) {
        return messageRepository.findByProfileId(profileId);
    }

    public void deleteMessageById(Long profileId, Long messageId) {
        Message message = messageRepository.findByIdAndProfileId(messageId, profileId)
                .orElseThrow( () -> new IllegalArgumentException("Message not found for this profile."));
        messageRepository.delete(message);
    }
}
