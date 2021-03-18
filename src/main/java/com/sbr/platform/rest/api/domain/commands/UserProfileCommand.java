package com.sbr.platform.rest.api.domain.commands;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;

public interface UserProfileCommand {
    /**
     * Method to create userProfile
     *
     * @param userProfileDTO
     * @return
     */
    UserProfileDTO createUserProfile(final UserProfileDTO userProfileDTO);

    /**
     * Method to update the userProfile
     *
     * @param userProfileDTO
     * @return
     */
    UserProfileDTO updateUserProfile(final UserProfileDTO userProfileDTO);

    /**
     * Method to delete the user Profile
     *
     * @param userId
     * @return
     */
    Boolean deleteUserProfile(final String userId);
}
