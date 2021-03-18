package com.sbr.platform.rest.api.domain.service;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;

public interface UserProfileCommandService {

    /**
     * Method to create userProfile
     *
     * @param userProfileDTO
     * @return
     */
    String createUserProfile(UserProfileDTO userProfileDTO);

    /**
     * Method to update the userProfile
     *
     * @param existingUser
     * @param userProfileDTO
     * @return
     */
    String updateUserProfile(UserProfileDTO existingUser, UserProfileDTO userProfileDTO);

    /**
     * Method to delete the userProfile
     *
     * @param userId
     * @return
     */
    Boolean deleteUserProfile(final String userId);
}
