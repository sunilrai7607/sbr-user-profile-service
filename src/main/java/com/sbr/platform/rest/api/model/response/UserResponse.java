package com.sbr.platform.rest.api.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1196340906602076761L;

    private String userId;
}
