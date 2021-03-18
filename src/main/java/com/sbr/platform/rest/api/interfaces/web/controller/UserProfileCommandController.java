package com.sbr.platform.rest.api.interfaces.web.controller;

import com.sbr.platform.rest.api.domain.dto.UserProfileDTO;
import com.sbr.platform.rest.api.domain.exception.ResourceNotFoundException;
import com.sbr.platform.rest.api.domain.mapper.UserProfileDtoMapper;
import com.sbr.platform.rest.api.domain.service.UserProfileCommandService;
import com.sbr.platform.rest.api.domain.service.UserProfileQueryService;
import com.sbr.platform.rest.api.interfaces.web.model.UserProfileRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/users")
@Validated
@Slf4j
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class UserProfileCommandController {

    private final UserProfileCommandService userProfileCommandService;
    private final UserProfileQueryService userProfileQueryService;

    @Autowired
    public UserProfileCommandController(UserProfileCommandService userProfileCommandService, UserProfileQueryService userProfileQueryService) {
        this.userProfileCommandService = userProfileCommandService;
        this.userProfileQueryService = userProfileQueryService;
    }

    @PostMapping
    public ResponseEntity<String> createProfile(@RequestBody UserProfileRequest userProfileRequest) {
        return ResponseEntity.ok(userProfileCommandService.createUserProfile(UserProfileDtoMapper.INSTANCE.mapToDto(userProfileRequest)));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateProfile(@PathVariable("userId") @NotBlank
                                                @Size(
                                                        max = 10,
                                                        message = "The userId '${validatedValue}' must be between {min} and {max} characters long"
                                                ) final String userId, @RequestBody UserProfileRequest userProfileRequest) {

        UserProfileDTO existingUser = Optional.ofNullable(this.userProfileQueryService.getUserProfileById(userId)).orElseThrow(() -> new ResourceNotFoundException());
        return ResponseEntity.ok(userProfileCommandService.updateUserProfile(existingUser, UserProfileDtoMapper.INSTANCE.mapToDto(userProfileRequest)));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteProfile(@PathVariable("userId") @NotBlank
                                                 @Size(
                                                         max = 10,
                                                         message = "The userId '${validatedValue}' must be between {min} and {max} characters long"
                                                 ) final String userId) {
        return ResponseEntity.ok(userProfileCommandService.deleteUserProfile(userId));
    }
}
