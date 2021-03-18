package com.sbr.platform.rest.api.repository.mapper;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.repository.entity.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserProfileEntityMapper {

    UserProfileEntityMapper INSTANCE = Mappers.getMapper(UserProfileEntityMapper.class);

    /**
     * Method to convert UserProfileDto to UserProfileEntity
     *
     * @param userProfileDTO
     * @return
     */
    UserProfileEntity mapToEntity(final UserProfileDTO userProfileDTO);

    /**
     * Method to convert UserProfileEntity to UserProfileDto
     *
     * @param userProfileEntity
     * @return
     */
    UserProfileDTO mapToDto(final UserProfileEntity userProfileEntity);
}
