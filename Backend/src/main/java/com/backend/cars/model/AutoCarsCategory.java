package com.backend.cars.model;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.category.CategoryRequestDto;
import com.backend.cars.util.DateUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "auto_cars_category")
public class AutoCarsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`title`", columnDefinition = "TEXT")
    private String title;

    @Column(name = "`image`", columnDefinition = "TEXT")
    private String image;

    @Column(name = "`description`", columnDefinition = "TEXT")
    private String description;

    @Column(name = "`published`", columnDefinition = "TINYINT", nullable = false)
    private int published;

    @Column(name = "sort_order", columnDefinition = "INT(11)")
    private Integer sortOrder;

    @Column(name = "state", columnDefinition = "TINYINT", nullable = false)
    private int state;

    @Column(name = "created", columnDefinition = "INT(11)", nullable = false)
    private int created;

    @Column(name = "modified", columnDefinition = "INT(11)")
    private Integer modified;

    @OneToMany(mappedBy = "autoCarsCategory")
    private Set<AutoCarsCategoryItem> sellCarCategoryItem;

    public AutoCarsCategory() {
    }

    public AutoCarsCategory(int id, String title, String image, String description, int published, Integer sortOrder, int state, int created, Integer modified, Set<AutoCarsCategoryItem> sellCarCategoryItem) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.published = published;
        this.sortOrder = sortOrder;
        this.state = state;
        this.created = created;
        this.modified = modified;
        this.sellCarCategoryItem = sellCarCategoryItem;
    }

    public AutoCarsCategory(CategoryRequestDto categoryRequestDto) {
        this.created = DateUtils.getCurrentTimeSecond();
        this.description = categoryRequestDto.getDescription();
        this.image = categoryRequestDto.getImage();
        this.published = categoryRequestDto.getPublish();
        this.title = categoryRequestDto.getTitle();
        this.state = State.ACTIVE.getId();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public Set<AutoCarsCategoryItem> getSellCarCategoryItem() {
        return sellCarCategoryItem;
    }

    public void setSellCarCategoryItem(Set<AutoCarsCategoryItem> helpCategoryQuestions) {
        this.sellCarCategoryItem = helpCategoryQuestions;
    }

    public void update(CategoryRequestDto categoryRequestDto) {
        this.published = categoryRequestDto.getPublish();
        this.title = categoryRequestDto.getTitle();
        this.image = categoryRequestDto.getImage();
        this.description = categoryRequestDto.getDescription();
        this.modified = DateUtils.getCurrentTimeSecond();
    }
}
