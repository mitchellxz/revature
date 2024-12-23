package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Following;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.FollowerRepository;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;
    private final ProfileRepository profileRepository;

    public FollowerService(FollowerRepository followerRepository, ProfileRepository profileRepository) {
        this.followerRepository = followerRepository;
        this.profileRepository = profileRepository;
    }

    public List<Following> getFollowersByProfileId(Long profileId) {
        List<Following> followings = followerRepository.findByFollowedProfileId(profileId);
        if (followings.isEmpty()) {
            throw new IllegalArgumentException("No followers to display.");
        }
        return followings;
    }

    public void followProfile(Long followerProfileId, Long followedProfileId) {
        if (followerProfileId.equals(followedProfileId)) {
            throw new IllegalArgumentException("You cannot follow yourself.");
        }
       Profile followerProfile = profileRepository.findById(followerProfileId)
               .orElseThrow(() -> new IllegalArgumentException("Follower profile not found."));

       Profile followedProfile = profileRepository.findById(followedProfileId)
               .orElseThrow( () -> new IllegalArgumentException("Followed profile not found"));

       Optional<Following> existingFollower = followerRepository
               .findByFollowerProfileIdAndFollowedProfileId(followerProfileId, followedProfileId);
       if (existingFollower.isPresent()) {
           throw new IllegalArgumentException("You are already following this profile.");
       }

       Optional<Following> reverseFollow = followerRepository.findByFollowerProfileIdAndFollowedProfileId(followedProfileId, followerProfileId);


       Following newFollowing = new Following();
       newFollowing.setFollowerProfile(followerProfile);
       newFollowing.setFollowedProfile(followedProfile);

       if (reverseFollow.isPresent()) {
           newFollowing.setMutual(true);
           reverseFollow.get().setMutual(true);
           followerRepository.save(reverseFollow.get());
       }
       followerRepository.save(newFollowing);
    }

    public void unfollowProfile(Long followerProfileId, Long followedProfileId) {
        Following existingFollowing = followerRepository.findByFollowerProfileIdAndFollowedProfileId(followerProfileId, followedProfileId)
                .orElseThrow( () -> new IllegalArgumentException("You are not following this person."));

        Optional<Following> reverseFollow = followerRepository.findByFollowerProfileIdAndFollowedProfileId(followedProfileId, followerProfileId);

        if(reverseFollow.isPresent() && existingFollowing.isMutual()) {
            Following reverseFollowing = reverseFollow.get();
            reverseFollowing.setMutual(false);
            followerRepository.save(reverseFollowing);
        }

        followerRepository.delete(existingFollowing);
    }
}
