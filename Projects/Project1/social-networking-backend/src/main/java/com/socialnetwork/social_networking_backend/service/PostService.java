package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Following;
import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.FollowerRepository;
import com.socialnetwork.social_networking_backend.repository.PostRepository;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private static Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final FollowerRepository followerRepository;

    public PostService(PostRepository postRepository, ProfileRepository profileRepository, FollowerRepository followerRepository) {
        this.postRepository = postRepository;
        this.profileRepository = profileRepository;
        this.followerRepository = followerRepository;
    }

    public Post createPost(Long profileId, Post post) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow( () -> new IllegalArgumentException("Profile not found with ID " + profileId));

        post.setProfile(profile);

        if (post.getCreatedAt() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long profileId, Long postId) {
        Optional<Post> optionalPost = postRepository.findByIdAndProfileId(postId, profileId);
        if (optionalPost.isEmpty()) {
            throw new IllegalArgumentException("No post to display.");
        }
        return optionalPost.get();
    }

    public List<Post> getAllPostsByProfileId(Long profileId) {
        return postRepository.findByProfileId(profileId);
    }

    public void deletePostById(Long profileId, Long postId) {
        Post post = postRepository.findByIdAndProfileId(postId, profileId)
                .orElseThrow( () -> new IllegalArgumentException("Post not found for this profile."));
        postRepository.delete(post);
    }

    public List<Post> getPostsForFollowing(Long profileId) {
        List<Following> followings = followerRepository.findByFollowerProfileId(profileId);;
        List<Profile> followedProfiles = followings.stream().map(Following::getFollowedProfile).toList();



        return postRepository.findByProfileIn(followedProfiles);
    }
}
