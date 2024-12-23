package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Message;
import com.socialnetwork.social_networking_backend.service.MessageService;
import com.socialnetwork.social_networking_backend.service.ProfileService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/message")
@RestController
public class MessageController {
    private final ProfileService profileService;
    private final MessageService messageService;

    public MessageController(ProfileService profileService, MessageService messageService) {
        this.profileService = profileService;
        this.messageService = messageService;
    }

    @PostMapping("/{profileId}/{postId}/create")
    public Message createMessage(@PathVariable Long profileId, @PathVariable Long postId, @RequestBody Message message) {
        return messageService.createMessage(profileId, postId, message);
    }

    @GetMapping("/all")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{profileId}/{messageId}")
    public Message getMessageById(@PathVariable Long profileId, @PathVariable Long messageId) {
        return messageService.getMessageById(profileId, messageId);
    }

    @GetMapping("/{profileId}/all")
    public List<Message> getAllMessagesbyProfileId(@PathVariable Long profileId) {
        return messageService.getAllMessagesByProfileId(profileId);
    }

    @DeleteMapping("/{profileId}/{messageId}/delete")
    public ResponseEntity<String> deleteMessageById(@PathVariable Long profileId, @PathVariable Long messageId) {
        messageService.deleteMessageById(profileId, messageId);
        return ResponseEntity.ok("Message Deleted.");
    }


}
