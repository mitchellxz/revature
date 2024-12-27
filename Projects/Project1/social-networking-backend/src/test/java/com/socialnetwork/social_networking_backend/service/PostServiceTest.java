package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Following;
import com.socialnetwork.social_networking_backend.model.Post;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.FollowerRepository;
import com.socialnetwork.social_networking_backend.repository.PostRepository;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private FollowerRepository followerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPost_ValidProfileId_ReturnsSavedPost() {
        Long profileId = 1L;
        Profile profile = new Profile();
        profile.setId(profileId);
        Post post = new Post();
        post.setContent("Test content");
        when(profileRepository.findById(profileId)).thenReturn(Optional.of(profile));
        when(postRepository.save(any(Post.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Post result = postService.createPost(profileId, post);

        assertNotNull(result);
        assertEquals(profile, result.getProfile());
        assertNotNull(result.getCreatedAt());
        verify(profileRepository, times(1)).findById(profileId);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void createPost_InvalidProfileId_ThrowsException() {
        Long profileId = 1L;
        Post post = new Post();
        when(profileRepository.findById(profileId)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            postService.createPost(profileId, post);
        });
        assertEquals("Profile not found with ID 1", exception.getMessage());
        verify(profileRepository, times(1)).findById(profileId);
        verify(postRepository, times(0)).save(any(Post.class));
    }

    @Test
    void getAllPosts_ReturnsListOfPosts() {
        List<Post> posts = Arrays.asList(new Post(), new Post());
        when(postRepository.findAll()).thenReturn(posts);

        List<Post> result = postService.getAllPosts();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(postRepository, times(1)).findAll();
    }

    @Test
    void getPostById_ValidIds_ReturnsPost() {
        Long profileId = 1L;
        Long postId = 2L;
        Post post = new Post();
        when(postRepository.findByIdAndProfileId(postId, profileId)).thenReturn(Optional.of(post));

        Post result = postService.getPostById(profileId, postId);

        assertNotNull(result);
        verify(postRepository, times(1)).findByIdAndProfileId(postId, profileId);
    }

    @Test
    void getPostById_InvalidIds_ThrowsException() {
        Long profileId = 1L;
        Long postId = 2L;
        when(postRepository.findByIdAndProfileId(postId, profileId)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            postService.getPostById(profileId, postId);
        });
        assertEquals("No post to display.", exception.getMessage());
        verify(postRepository, times(1)).findByIdAndProfileId(postId, profileId);
    }

    @Test
    void getAllPostsByProfileId_ReturnsListOfPosts() {
        Long profileId = 1L;
        List<Post> posts = Arrays.asList(new Post(), new Post());
        when(postRepository.findByProfileId(profileId)).thenReturn(posts);

        List<Post> result = postService.getAllPostsByProfileId(profileId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(postRepository, times(1)).findByProfileId(profileId);
    }

    @Test
    void deletePostById_ValidIds_DeletesPost() {
        Long profileId = 1L;
        Long postId = 2L;
        Post post = new Post();
        when(postRepository.findByIdAndProfileId(postId, profileId)).thenReturn(Optional.of(post));

        postService.deletePostById(profileId, postId);

        verify(postRepository, times(1)).findByIdAndProfileId(postId, profileId);
        verify(postRepository, times(1)).delete(post);
    }

    @Test
    void deletePostById_InvalidIds_ThrowsException() {
        Long profileId = 1L;
        Long postId = 2L;
        when(postRepository.findByIdAndProfileId(postId, profileId)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            postService.deletePostById(profileId, postId);
        });
        assertEquals("Post not found for this profile.", exception.getMessage());
        verify(postRepository, times(1)).findByIdAndProfileId(postId, profileId);
        verify(postRepository, times(0)).delete(any(Post.class));
    }



}
