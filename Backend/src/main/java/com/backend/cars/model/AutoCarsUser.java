package com.backend.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "auto_cars_user")
public class AutoCarsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private int id;

    @Column(name = "`state`", columnDefinition = "INT(11) DEFAULT 2", nullable = false)
    private int state;

    @Column(name = "`username`", unique = true, columnDefinition = "VARCHAR(255)", nullable = false)
    private String username;

    @Column(name = "`password`", columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @Column(name = "`secret_key`", columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
    private String secretKey;

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

    @Column(name = "`role`", columnDefinition = "TINYINT(1) DEFAULT 0", nullable = false)
    private int role;

    public AutoCarsUser() {
    }

    public AutoCarsUser(int id, int state, String username, String password, String secretKey, String details, int created, Integer modified, String email, String phoneNumber, int role) {
        this.id = id;
        this.state = state;
        this.username = username;
        this.password = password;
        this.secretKey = secretKey;
        this.details = details;
        this.created = created;
        this.modified = modified;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String keySecret) {
        this.secretKey = keySecret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
