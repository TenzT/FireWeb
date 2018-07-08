package com.fireengineering.management.po;

public class Deployment {
    private Integer deploymentId;

    private Integer projectId;

    private String deploymentLocation;

    private Integer spotId;

    private String depolymentDesc;

    public Integer getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(Integer deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getDeploymentLocation() {
        return deploymentLocation;
    }

    public void setDeploymentLocation(String deploymentLocation) {
        this.deploymentLocation = deploymentLocation == null ? null : deploymentLocation.trim();
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public String getDepolymentDesc() {
        return depolymentDesc;
    }

    public void setDepolymentDesc(String depolymentDesc) {
        this.depolymentDesc = depolymentDesc == null ? null : depolymentDesc.trim();
    }
}