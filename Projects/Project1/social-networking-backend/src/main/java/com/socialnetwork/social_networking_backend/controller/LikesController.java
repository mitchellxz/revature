package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Likes;
import com.socialnetwork.social_networking_backend.service.LikesService;
import com.socialnetwork.social_networking_backend.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/likes")
@RestController
public class LikesController {
    private final LikesService likesService;
    private final PostService postService;

    public LikesController(LikesService likesService, PostService postService) {
        this.likesService = likesService;
        this.postService = postService;
    }

    @PostMapping("/{postId}/{profileId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId, @PathVariable Long profileId) {
        likesService.likePost(postId, profileId);
        return ResponseEntity.ok("Post liked.");
    }

    @DeleteMapping("/{postId}/{profileId}")
    public ResponseEntity<String> unlikePost(@PathVariable Long postId, @PathVariable Long profileId) {
        likesService.unlikePost(postId, profileId);
        return ResponseEntity.ok("Post unliked.");
    }

    @GetMapping("/post/{postId}")
    public List<Likes> getLikesByPostId(@PathVariable Long postId) {
        return likesService.getLikesByPostId(postId);
    }

    @GetMapping("/profile/{profileId}")
    public List<Likes> getLikesByProfileId(@PathVariable Long profileId) {
        return likesService.getLikesByProfileId(profileId);
    }

    @GetMapping("/all")
    public List<Likes> getLikes() {
        return likesService.getLikes();
    }
}
