package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Following;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.service.FollowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/followers")
@RestController
public class FollowerController {
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping("/profile/{profileId}")
    public List<Following> getFollowersByProfileId(@PathVariable Long profileId) {
        return followerService.getFollowersByProfileId(profileId);
    }

    @PostMapping("/{followerProfileId}")
    public ResponseEntity<String> followProfile(@PathVariable Long followerProfileId, @RequestParam Long followedProfileId) {
        System.out.println(followerProfileId + " " + followedProfileId);
        followerService.followProfile(followerProfileId, followedProfileId);
        return ResponseEntity.ok("Profile followed.");
    }

    @DeleteMapping("/{followerProfileId}")
    public ResponseEntity<String> unfollowProfile(@PathVariable Long followerProfileId, @RequestParam Long followedProfileId) {
        followerService.unfollowProfile(followerProfileId, followedProfileId);
        return ResponseEntity.ok("unfollowed.");
    }

}
