package com.sbr.platform.rest.api.interfaces.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 1196340906602076761L;

    private String userId;
}
