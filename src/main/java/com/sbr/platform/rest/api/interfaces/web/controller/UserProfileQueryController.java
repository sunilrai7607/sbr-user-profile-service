package com.sbr.platform.rest.api.interfaces.web.controller;

import com.sbr.platform.rest.api.domain.mapper.UserProfileDtoMapper;
import com.sbr.platform.rest.api.domain.service.UserProfileQueryService;
import com.sbr.platform.rest.api.interfaces.web.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping(value = "/api/v1/users")
@Slf4j
//@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
@Validated
public class UserProfileQueryController {

    private final UserProfileQueryService userProfileQueryService;

    @Autowired
    public UserProfileQueryController(UserProfileQueryService userProfileQueryService) {
        this.userProfileQueryService = userProfileQueryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId")
                                                    @NotBlank
                                                    @Size(
                                                            max = 10,
                                                            message = "The userId '${validatedValue}' must be between {min} and {max} characters long"
                                                    ) final String userId) {
        return ResponseEntity.ok(UserProfileDtoMapper.INSTANCE.mapToResponse(userProfileQueryService.getUserProfileById(userId)));
    }
}
