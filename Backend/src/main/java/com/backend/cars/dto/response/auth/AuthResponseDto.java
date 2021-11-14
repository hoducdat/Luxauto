package com.backend.cars.dto.response.auth;

import com.backend.cars.model.AutoCarsUser;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty("secret_key")
    private String secretKey;
    @JsonProperty("user_id")
    private Integer userId;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String secretKey, Integer userId) {
        this.secretKey = secretKey;
        this.userId = userId;
    }

    public AuthResponseDto(AutoCarsUser autoCarsUser) {
        this.secretKey = autoCarsUser.getSecretKey();
        this.userId = autoCarsUser.getId();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
