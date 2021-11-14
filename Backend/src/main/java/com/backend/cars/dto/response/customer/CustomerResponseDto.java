package com.backend.cars.dto.response.customer;

import com.backend.cars.dto.response.item.ItemResponseDto;
import com.backend.cars.model.AutoCarsCustomer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("created")
    private int created;

    @JsonProperty("auto_cars_item")
    private ItemResponseDto itemResponseDto;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("state")
    private int state;

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(AutoCarsCustomer autoCarsCustomer) {
        this.created = autoCarsCustomer.getCreated();
        this.email = autoCarsCustomer.getEmail();
        this.id = autoCarsCustomer.getId();
        this.name = autoCarsCustomer.getName();
        this.phoneNumber = autoCarsCustomer.getPhoneNumber();
        this.state = autoCarsCustomer.getState();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public ItemResponseDto getItemResponseDto() {
        return itemResponseDto;
    }

    public void setItemResponseDto(ItemResponseDto itemResponseDto) {
        this.itemResponseDto = itemResponseDto;
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
