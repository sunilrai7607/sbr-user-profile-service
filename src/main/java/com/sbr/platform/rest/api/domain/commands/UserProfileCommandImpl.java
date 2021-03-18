package com.sbr.platform.rest.api.domain.commands;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class UserProfileCommandImpl implements UserProfileCommand {
    /**
     * Method to create userProfile
     *
     * @param userProfileDTO
     * @return
     */
    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        return userProfileDTO;
    }

    /**
     * Method to update the userProfile
     *
     * @param userProfileDTO
     * @return
     */
    @Override
    public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO) {
        return null;
    }

    /**
     * Method to delete the user Profile
     *
     * @param userId
     * @return
     */
    @Override
    public Boolean deleteUserProfile(String userId) {
        return null;
    }
}
