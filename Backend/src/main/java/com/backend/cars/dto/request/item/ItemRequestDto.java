package com.backend.cars.dto.request.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemRequestDto {
    @JsonProperty("category_id")
    private int categoryId;

    @Min(0)
    @JsonProperty("price")
    private long price;

    @NotNull @NotEmpty
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @NotNull @NotEmpty
    @JsonProperty("content")
    private String content;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @Min(0) @Max(1)
    @JsonProperty("published")
    private int published;

    @JsonProperty("details")
    private String details;

    public ItemRequestDto() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }
}
