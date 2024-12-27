package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProfileServiceTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileService profileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProfileByAccountId_ProfileExists() {
        Long accountId = 1L;
        Profile mockProfile = new Profile();
        mockProfile.setId(accountId);

        when(profileRepository.findByAccount_Id(accountId)).thenReturn(Optional.of(mockProfile));

        Profile profile = profileService.getProfileByAccountId(accountId);

        assertNotNull(profile);
        assertEquals(accountId, profile.getId());
        verify(profileRepository, times(1)).findByAccount_Id(accountId);
    }
    @Test
    void testGetProfileByAccountId_ProfileDoesNotExist() {
        Long accountId = 1L;

        when(profileRepository.findByAccount_Id(accountId)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            profileService.getProfileByAccountId(accountId);
        });

        assertEquals("No profile to display.", exception.getMessage());
        verify(profileRepository, times(1)).findByAccount_Id(accountId);
    }
    @Test
    void testGetAllProfiles() {
        Profile profile1 = new Profile();
        Profile profile2 = new Profile();
        List<Profile> profiles = List.of(profile1, profile2);

        when(profileRepository.findAll()).thenReturn(profiles);

        List<Profile> result = profileService.getAllProfiles();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(profileRepository, times(1)).findAll();
    }

    @Test
    void testEditProfile_ProfileExists() {
        Long accountId = 1L;
        Profile existingProfile = new Profile();
        existingProfile.setId(accountId);
        existingProfile.setFullName("Old Name");

        Profile updatedProfile = new Profile();
        updatedProfile.setFullName("New Name");

        when(profileRepository.findById(accountId)).thenReturn(Optional.of(existingProfile));
        when(profileRepository.save(existingProfile)).thenReturn(existingProfile);

        Profile result = profileService.editProfile(accountId, updatedProfile);

        assertNotNull(result);
        assertEquals("New Name", result.getFullName());
        verify(profileRepository, times(1)).findById(accountId);
        verify(profileRepository, times(1)).save(existingProfile);
    }

    @Test
    void testEditProfile_ProfileDoesNotExist() {
        Long accountId = 1L;
        Profile updatedProfile = new Profile();

        when(profileRepository.findById(accountId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            profileService.editProfile(accountId, updatedProfile);
        });

        assertEquals("Profile not found.", exception.getMessage());
        verify(profileRepository, times(1)).findById(accountId);
    }

    @Test
    void testCreateProfile() {
        Profile newProfile = new Profile();
        when(profileRepository.save(newProfile)).thenReturn(newProfile);

        Profile result = profileService.createProfile(newProfile);

        assertNotNull(result);
        verify(profileRepository, times(1)).save(newProfile);
    }

    @Test
    void testGetFollowedProfiles() {
        Long followerProfileId = 1L;
        Profile followedProfile1 = new Profile();
        Profile followedProfile2 = new Profile();
        List<Profile> followedProfiles = List.of(followedProfile1, followedProfile2);

        when(profileRepository.findFollowedProfiles(followerProfileId)).thenReturn(followedProfiles);

        List<Profile> result = profileService.getFollowedProfiles(followerProfileId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(profileRepository, times(1)).findFollowedProfiles(followerProfileId);
    }
}
