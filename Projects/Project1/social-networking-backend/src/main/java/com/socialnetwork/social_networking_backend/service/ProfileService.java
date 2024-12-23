package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfileByAccountId(Long accountId) {
        Optional<Profile> optionalProfile = profileRepository.findByAccount_Id(accountId);
        if (optionalProfile.isEmpty()) {
            throw new IllegalArgumentException("No profile to display.");
        }

        return optionalProfile.get();
    }

    public Profile getProfileByUsername(String username) {
        Optional<Profile> optionalProfile = profileRepository.findByAccount_Username(username);
        if (optionalProfile.isEmpty()) {
            throw new IllegalArgumentException("No profile to display.");
        }
        return optionalProfile.get();
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile editProfile(Long accountId, Profile updatedProfile) {
        Profile existingProfile = profileRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Profile not found."));

        if (updatedProfile.getFullName() != null) {
            if (!updatedProfile.getFullName().isBlank()) {
                existingProfile.setFullName(updatedProfile.getFullName());
            }
        }
        if (updatedProfile.getBio() != null) {
            if (!updatedProfile.getBio().isBlank()) {
                existingProfile.setBio(updatedProfile.getBio());
            }
        }
        if (updatedProfile.getLocation() != null) {
            if (!updatedProfile.getLocation().isBlank()) {
                existingProfile.setLocation(updatedProfile.getLocation());
            }
        }
        if (updatedProfile.getProfilePicture() != null) {
            if (!updatedProfile.getProfilePicture().isBlank()) {
                existingProfile.setProfilePicture(updatedProfile.getProfilePicture());
            }
        }


        return profileRepository.save(existingProfile);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public List<Profile> getFollowedProfiles(Long followerProfileId) {
        return profileRepository.findFollowedProfiles(followerProfileId);
    }
}
