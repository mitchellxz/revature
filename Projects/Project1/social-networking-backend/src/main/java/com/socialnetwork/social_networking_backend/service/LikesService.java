package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Likes;
import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.LikesRepository;
import com.socialnetwork.social_networking_backend.repository.PostRepository;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;

    public LikesService(LikesRepository likesRepository, PostRepository postRepository, ProfileRepository profileRepository) {
        this.likesRepository = likesRepository;
        this.postRepository = postRepository;
        this.profileRepository = profileRepository;
    }
    public void likePost(Long postId, Long profileId) {
        if (likesRepository.findByPostIdAndProfileId(postId, profileId).isPresent()) {
            throw new IllegalArgumentException("Post already liked by this profile.");
        }

        Post post = postRepository.findById(postId)
                .orElseThrow( () -> new IllegalArgumentException("Post not found."));
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow( () -> new IllegalArgumentException("Profile not found."));

        Likes likes = new Likes();
        likes.setPost(post);
        likes.setProfile(profile);
        likesRepository.save(likes);
    }

    public void unlikePost(Long postId, Long profileId) {
        Likes likes = likesRepository.findByPostIdAndProfileId(postId, profileId)
                .orElseThrow(() -> new IllegalArgumentException("Like not found."));
        likesRepository.delete(likes);
    }

    public List<Likes> getLikesByPostId(Long postId) {
        List<Likes> likes = likesRepository.findByPostId(postId);
        if (likes.isEmpty()) {
            throw new IllegalArgumentException("No likes to display.");
        }
        return likes;
    }

    public List<Likes> getLikesByProfileId(Long profileId) {
        List<Likes> likes = likesRepository.findByProfileId(profileId);
        if (likes.isEmpty()) {
            throw new IllegalArgumentException("No likes to display.");
        }
        return likes;
    }


    public List<Likes> getLikes() {
        return likesRepository.findAll();
    }
}
