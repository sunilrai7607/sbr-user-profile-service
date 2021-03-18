package com.sbr.platform.rest.api.domain.service;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;

public interface UserProfileQueryService {
    /**
     * Method to get the user profile by Id
     *
     * @param userId
     * @return
     */
    UserProfileDTO getUserProfileById(final String userId);

    /**
     * Method to validate the user by userId
     *
     * @param userId
     * @return
     */
    boolean existingUser(final String userId);
}
