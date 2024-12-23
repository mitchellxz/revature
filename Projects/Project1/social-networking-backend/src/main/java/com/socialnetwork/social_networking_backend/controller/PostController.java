package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.service.PostService;
import com.socialnetwork.social_networking_backend.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/post")
@RestController
public class PostController {
    private final ProfileService profileService;
    private final PostService postService;

    public PostController(ProfileService profileService, PostService postService) {
        this.profileService = profileService;
        this.postService = postService;
    }

    @PostMapping("/{profileId}/create")
    public Post createPost(@PathVariable Long profileId, @RequestBody Post post) {
        return postService.createPost(profileId, post);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{profileId}/all")
    public List<Post> getAllPostsByProfileId(@PathVariable Long profileId) {
        return postService.getAllPostsByProfileId(profileId);
    }

    @GetMapping("/{profileId}/{postId}")
    public Post getPostById(@PathVariable Long profileId, @PathVariable Long postId) {
        return postService.getPostById(profileId, postId);
    }

    @DeleteMapping("{profileId}/{postId}/delete")
    public ResponseEntity<String> deletePostById(@PathVariable Long profileId, @PathVariable Long postId) {
        postService.deletePostById(profileId, postId);
        return ResponseEntity.ok("Post Deleted");
    }

    @GetMapping("/following/{profileId}")
    public ResponseEntity<List<Post>> getPostsForFollowing(@PathVariable Long profileId) {
        List<Post> posts = postService.getPostsForFollowing(profileId);
        return ResponseEntity.ok(posts);
    }
}
