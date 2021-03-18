package com.sbr.platform.rest.api.interfaces.web.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserProfileRequest implements Serializable {


    private static final long serialVersionUID = 8978378172874921725L;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;
}
