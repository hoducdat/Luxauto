package com.backend.cars.dto.response.item;

import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemResponseDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("category_list")
    private List<Object> carsCategories;

    @JsonProperty("price")
    private Long price;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("sort_order")
    private int sortOrder;

    @JsonProperty("published")
    private int published;

    @JsonProperty("state")
    private int state;

    @JsonProperty("modified")
    private Integer modified;

    @JsonProperty("published_time")
    private Integer publishedTime;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("content")
    private String content;

    @JsonProperty("details")
    private String details;

    @JsonProperty("created")
    private int created;

    public ItemResponseDto() {
    }

    public ItemResponseDto(AutoCarsItem autoCarsItem) {
        this.id = autoCarsItem.getId();
        this.title = autoCarsItem.getTitle();
        this.description = autoCarsItem.getDescription();
        this.sortOrder = autoCarsItem.getSortOrder();
        this.published = autoCarsItem.getPublished();
        this.state = autoCarsItem.getState();
        this.modified = autoCarsItem.getModified();
        this.publishedTime = autoCarsItem.getPublishedTime();
        this.thumbnail = autoCarsItem.getThumbnail();
        this.created = autoCarsItem.getCreated();
        this.price = autoCarsItem.getPrice();
        this.content = autoCarsItem.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getCarsCategories() {
        return carsCategories;
    }

    public void setCarsCategories(List<Object> carsCategories) {
        this.carsCategories = carsCategories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public Integer getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Integer publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }
}
