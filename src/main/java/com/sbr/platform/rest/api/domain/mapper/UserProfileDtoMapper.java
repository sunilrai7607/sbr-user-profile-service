package com.sbr.platform.rest.api.domain.mapper;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.interfaces.web.model.UserProfileRequest;
import com.sbr.platform.rest.api.interfaces.web.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserProfileDtoMapper {

    UserProfileDtoMapper INSTANCE = Mappers.getMapper(UserProfileDtoMapper.class);

    UserResponse mapToResponse(UserProfileDTO userProfileDTO);

    @Mapping(target = "firstName", source = "userProfileRequest.firstName")
    UserProfileDTO mapToDto(UserProfileRequest userProfileRequest);
}
