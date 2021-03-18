package com.sbr.platform.rest.api.domain.service.impl;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.domain.service.UserProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileQueryServiceImpl implements UserProfileQueryService {
    /**
     * Method to get the user profile by Id
     *
     * @param userId
     * @return
     */
    @Override
    public UserProfileDTO getUserProfileById(String userId) {
        return null;
    }

    /**
     * Method to validate the user by userId
     *
     * @param userId
     * @return
     */
    @Override
    public boolean existingUser(String userId) {
        return false;
    }
}
