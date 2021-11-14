package com.backend.cars.model;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.customer.CustomerRequestDto;
import com.backend.cars.util.DateUtils;

import javax.persistence.*;

@Entity
@Table(name = "auto_cars_customer")
public class AutoCarsCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "`auto_cars_item_id`", columnDefinition = "INT(11)")
    private AutoCarsItem autoCarsItem;

    @Column(name = "`state`", columnDefinition = "INT(11) DEFAULT 2", nullable = false)
    private int state;

    @Column(name = "`name`", columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(name = "`details`", columnDefinition = "TEXT DEFAULT NULL", nullable = true)
    private String details;

    @Column(name = "`created`", columnDefinition = "INT(11)", nullable = false)
    private int created;

    @Column(name = "`modified`", columnDefinition = "INT(11) DEFAULT NULL", nullable = true)
    private Integer modified;

    @Column(name = "`email`", columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @Column(name = "`phone_number`", columnDefinition = "VARCHAR(20)", nullable = true)
    private String phoneNumber;

    public AutoCarsCustomer() {
    }

    public AutoCarsCustomer(int id, AutoCarsItem autoCarsItem, int state, String name, String details, int created, Integer modified, String email, String phoneNumber) {
        this.id = id;
        this.autoCarsItem = autoCarsItem;
        this.state = state;
        this.name = name;
        this.details = details;
        this.created = created;
        this.modified = modified;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AutoCarsCustomer(CustomerRequestDto customerRequestDto) {
        this.created = DateUtils.getCurrentTimeSecond();
        this.name = customerRequestDto.getName();
        this.state = State.ACTIVE.getId();
        this.email = customerRequestDto.getEmail();
        this.phoneNumber = customerRequestDto.getPhoneNumber();
    }

    public void updateCustomer() {
        this.state = State.INACTIVE.getId();
        this.modified = DateUtils.getCurrentTimeSecond();
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
