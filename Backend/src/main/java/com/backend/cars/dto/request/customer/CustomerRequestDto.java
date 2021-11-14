package com.backend.cars.dto.request.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerRequestDto {
    @JsonProperty("auto_cars_item_id")
    private int autoCarsItemId;

    @NotNull @NotBlank
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @NotNull @NotBlank
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("state")
    private Integer state;
    public CustomerRequestDto() {
    }

    public CustomerRequestDto(int autoCarsItemId, String name, String email, String phoneNumber) {
        this.autoCarsItemId = autoCarsItemId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public int getAutoCarsItemId() {
        return autoCarsItemId;
    }

    public void setAutoCarsItemId(int autoCarsItemId) {
        this.autoCarsItemId = autoCarsItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
