package com.backend.cars.model;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.item.ItemRequestDto;
import com.backend.cars.util.DateUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "auto_cars_item")
public class AutoCarsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`title`", columnDefinition = "VARCHAR(255)", nullable = false)
    private String title;

    @Column(name = "`thumbnail`", columnDefinition = "TEXT")
    private String thumbnail;

    @Column(name = "`description`", columnDefinition = "TEXT")
    private String description;

    @Column(name = "`content`", columnDefinition = "TEXT")
    private String content;

    @Column(name = "price", columnDefinition = "BIGINT")
    private Long price;

    @Column(name = "`sort_order`", columnDefinition = "INT(11)")
    private int sortOrder;

    @Column(name = "`published`", columnDefinition = "TINYINT(1)")
    private int published;

    @Column(name = "`published_time`", columnDefinition = "INT(11)")
    private Integer publishedTime;

    @Column(name = "`state`", columnDefinition = "INT(11)")
    private int state;

    @Column(name = "`modified`", columnDefinition = "INT(11)")
    private Integer modified;

    @Column(name = "`created`", columnDefinition = "INT(11)")
    private int created;

    @Column(name = "`details`", columnDefinition = "TEXT")
    private String details;

    @OneToMany(mappedBy = "autoCarsItem")
    private Set<AutoCarsCategoryItem> autoCarsCategoryItems;

    public AutoCarsItem() {
    }

    public AutoCarsItem(int id, String title, String thumbnail, String description, String content, Long price, int sortOrder, int published, Integer publishedTime, int state, Integer modified, int created, String details, Set<AutoCarsCategoryItem> autoCarsCategoryItems) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.price = price;
        this.sortOrder = sortOrder;
        this.published = published;
        this.publishedTime = publishedTime;
        this.state = state;
        this.modified = modified;
        this.created = created;
        this.details = details;
        this.autoCarsCategoryItems = autoCarsCategoryItems;
    }

    public AutoCarsItem(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.thumbnail = itemRequestDto.getThumbnail();
        this.description = itemRequestDto.getDescription();
        this.content = itemRequestDto.getContent();
        this.published = itemRequestDto.getPublished();
        this.publishedTime = DateUtils.getCurrentTimeSecond();
        this.state = State.ACTIVE.getId();
        this.created = DateUtils.getCurrentTimeSecond();
        this.price = itemRequestDto.getPrice();
        this.details = itemRequestDto.getDetails();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public Integer getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Integer publishedTime) {
        this.publishedTime = publishedTime;
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

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public Set<AutoCarsCategoryItem> getAutoCarsCategoryItems() {
        return autoCarsCategoryItems;
    }

    public void setAutoCarsCategoryItems(Set<AutoCarsCategoryItem> autoCarsCategoryItems) {
        this.autoCarsCategoryItems = autoCarsCategoryItems;
    }

    public void update(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.thumbnail = itemRequestDto.getThumbnail();
        this.description = itemRequestDto.getDescription();
        this.content = itemRequestDto.getContent();
        this.published = itemRequestDto.getPublished();
        this.publishedTime = DateUtils.getCurrentTimeSecond();
        this.state = State.ACTIVE.getId();
        this.modified = DateUtils.getCurrentTimeSecond();
    }
}
