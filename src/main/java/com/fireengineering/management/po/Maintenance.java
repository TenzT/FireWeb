package com.fireengineering.management.po;

public class Maintenance {
    private Integer maintenanceId;

    private String userId;

    private String deviceId;

    private String deploymentId;

    private String maintenanceRecord;

    private String maintenanceDesc;

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId == null ? null : deploymentId.trim();
    }

    public String getMaintenanceRecord() {
        return maintenanceRecord;
    }

    public void setMaintenanceRecord(String maintenanceRecord) {
        this.maintenanceRecord = maintenanceRecord == null ? null : maintenanceRecord.trim();
    }

    public String getMaintenanceDesc() {
        return maintenanceDesc;
    }

    public void setMaintenanceDesc(String maintenanceDesc) {
        this.maintenanceDesc = maintenanceDesc == null ? null : maintenanceDesc.trim();
    }
}