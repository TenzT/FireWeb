package com.fireengineering.management.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Maintenance {
    private Integer id;

    private Integer userId;

    private Integer deploymentId;

    private String record;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;

    private String note;

    private User user;

    private Deployment deployment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId == null ? null : userId;
    }

    public Integer getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(Integer deploymentId) {
        this.deploymentId = deploymentId == null ? null : deploymentId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }
}