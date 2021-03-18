package com.sbr.platform.rest.api.domain.queries.impl;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.domain.queries.UserProfileQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserProfileQueryImpl implements UserProfileQuery {
    @Override
    public UserProfileDTO getUserById(String userId) {
        return null;
    }
}
