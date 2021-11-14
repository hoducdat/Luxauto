package com.backend.cars.model;

import com.backend.cars.constant.State;
import com.backend.cars.util.DateUtils;

import javax.persistence.*;

@Entity
@Table(name = "auto_cars_category_item")
public class AutoCarsCategoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private int id;

    @ManyToOne
    @JoinColumn(name="`auto_cars_item_id`", nullable = false)
    private AutoCarsItem autoCarsItem;

    @ManyToOne
    @JoinColumn(name="`auto_cars_category_id`", nullable = false)
    private AutoCarsCategory autoCarsCategory;

    @Column(name = "state", columnDefinition = "TINYINT")
    private int state;

    @Column(name = "created", columnDefinition = "INT(11)")
    private int created;

    @Column(name = "modified", columnDefinition = "INT(11)")
    private Integer modified;

    public AutoCarsCategoryItem() {
    }

    public AutoCarsCategoryItem(int id, AutoCarsItem autoCarsItem, AutoCarsCategory autoCarsCategory, int state, int created, Integer modified) {
        this.id = id;
        this.autoCarsItem = autoCarsItem;
        this.autoCarsCategory = autoCarsCategory;
        this.state = state;
        this.created = created;
        this.modified = modified;
    }

    public AutoCarsCategoryItem(AutoCarsItem autoCarsItem, AutoCarsCategory autoCarsCategory) {
        this.created = DateUtils.getCurrentTimeSecond();
        this.autoCarsCategory = autoCarsCategory;
        this.autoCarsItem = autoCarsItem;
        this.state = State.ACTIVE.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AutoCarsItem getAutoCarsItem() {
        return autoCarsItem;
    }

    public void setAutoCarsItem(AutoCarsItem autoCarsItem) {
        this.autoCarsItem = autoCarsItem;
    }

    public AutoCarsCategory getAutoCarsCategory() {
        return autoCarsCategory;
    }

    public void setAutoCarsCategory(AutoCarsCategory autoCarsCategory) {
        this.autoCarsCategory = autoCarsCategory;
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
}
