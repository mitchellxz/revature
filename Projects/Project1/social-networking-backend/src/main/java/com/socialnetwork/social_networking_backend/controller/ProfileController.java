package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Following;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/create")
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping ("/all")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{accountId}")
    public Profile getProfileByAccountId(@PathVariable Long accountId) {
        return profileService.getProfileByAccountId(accountId);
    }

    @GetMapping("/user/{username}")
    public Profile getProfileByUsername(@PathVariable String username) {
        System.out.println("Fetching profile for username: " + username);
        return profileService.getProfileByUsername(username);
    }

    /*
    User should be able to modify the following profile settings:
    - full Name
    - Bio
    - Profile Picture
    - Location
     */
    @PatchMapping("/{accountId}/edit")
    public Profile editProfile(@PathVariable Long accountId, @RequestBody Profile profileUpdates) {
        return profileService.editProfile(accountId, profileUpdates);
    }

    @GetMapping("following/{followerProfileId}")
    public ResponseEntity<List<Profile>> getFollowedProfiles(@PathVariable Long followerProfileId) {
        return ResponseEntity.ok(profileService.getFollowedProfiles(followerProfileId));
    }

    @GetMapping("following/mutual/{followerId}")
    public ResponseEntity<Profile> getProfileByFollowerId(@PathVariable Long followerId) {
        Profile profile = profileService.getProfileByFollowerId(followerId);
        return ResponseEntity.ok(profile);
    }

}
