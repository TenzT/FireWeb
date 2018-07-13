package com.fireengineering.management.service;

import com.fireengineering.management.po.Maintenance;

import java.util.List;

public interface MaintenanceService {
    public int getMaintenanceCount();

    public List<Maintenance> getMaintenanceList(Integer offset, Integer limit);

    public int deleteMaintenanceById(Integer deploymentId);

    public int addMaintenance(Maintenance deployment);

    public int updateMaintenanceById(Maintenance deployment);
}
