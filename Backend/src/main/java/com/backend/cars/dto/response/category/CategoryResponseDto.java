package com.backend.cars.dto.response.category;

import com.backend.cars.model.AutoCarsCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoryResponseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("published")
    private int published;

    @JsonProperty("created")
    private int created;

    @JsonProperty("modified")
    private Integer modified;

    @JsonProperty("description")
    private String description;

    @JsonProperty("sort_order")
    private int sortOrder;

    @JsonProperty("state")
    private int state;

    @JsonProperty("auto_cars_item")
    private List<Object> autoCarsItemList;

    @JsonProperty("number_car")
    private Integer numberCar;

    @JsonProperty("image")
    private String image;

    public CategoryResponseDto() {
    }

    public CategoryResponseDto(AutoCarsCategory autoCarsCategory) {
        this.created = autoCarsCategory.getCreated();
        this.description = autoCarsCategory.getDescription();
        this.id = autoCarsCategory.getId();
        this.modified = autoCarsCategory.getModified();
        this.sortOrder = autoCarsCategory.getSortOrder();
        this.published = autoCarsCategory.getPublished();
        this.state = autoCarsCategory.getState();
        this.title = autoCarsCategory.getTitle();
        this.image = autoCarsCategory.getImage();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Object> getAutoCarsItemList() {
        return autoCarsItemList;
    }

    public void setAutoCarsItemList(List<Object> autoCarsItemList) {
        this.autoCarsItemList = autoCarsItemList;
    }

    public Integer getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(Integer numberCar) {
        this.numberCar = numberCar;
    }
}
