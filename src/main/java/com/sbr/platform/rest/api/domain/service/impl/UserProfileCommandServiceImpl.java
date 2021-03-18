package com.sbr.platform.rest.api.domain.service.impl;

import com.sbr.platform.rest.api.domain.commands.UserProfileCommand;
import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.domain.service.UserProfileCommandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserProfileCommandServiceImpl implements UserProfileCommandService {

    private final UserProfileCommand userProfileCommand;

    @Autowired
    public UserProfileCommandServiceImpl(UserProfileCommand userProfileCommand) {
        this.userProfileCommand = userProfileCommand;
    }

    /**
     * Method to create userProfile
     *
     * @param userProfileDTO
     * @return
     */
    @Override
    public String createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfileDTO newUserProfileDto = Optional.ofNullable(userProfileCommand.createUserProfile(userProfileDTO)).orElseThrow(() -> new RuntimeException());
        return Optional.ofNullable(newUserProfileDto.getUserId()).orElseThrow(() -> new RuntimeException());
    }

    /**
     * Method to update the userProfile
     *
     * @param existingUser
     * @param userProfileDTO
     * @return
     */
    @Override
    public String updateUserProfile(final UserProfileDTO existingUser, final UserProfileDTO userProfileDTO) {
        userProfileDTO.setUserId(existingUser.getUserId());
        UserProfileDTO updatedUserProfile = userProfileCommand.updateUserProfile(userProfileDTO);
        return StringUtils.equalsIgnoreCase(userProfileDTO.getUserId(), updatedUserProfile.getUserId()) ? "SUCCESS" : "FAILED";
    }

    /**
     * Method to delete the userProfile
     *
     * @param userId
     * @return
     */
    @Override
    public Boolean deleteUserProfile(final String userId) {
        return userProfileCommand.deleteUserProfile(userId);
    }
}
