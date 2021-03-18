package com.sbr.platform.rest.api.domain.queries;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;

public interface UserProfileQuery {

    UserProfileDTO getUserById(final String userId);
}
