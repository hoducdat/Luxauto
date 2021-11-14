package com.backend.cars.dto.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthRequestDto {
    @NotBlank @NotNull
    @JsonProperty("username")
    private String userName;

    @NotBlank @NotNull
    @JsonProperty("password")
    private String password;

    public AuthRequestDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
