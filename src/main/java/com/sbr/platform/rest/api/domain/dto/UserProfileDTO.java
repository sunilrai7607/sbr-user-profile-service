package com.sbr.platform.rest.api.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfileDTO implements Serializable {

    private static final long serialVersionUID = -1314222154969934493L;

    private String userId;

    private String firstName;

    private String lastName;
}
