package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.MaintenanceMapper;
import com.fireengineering.management.po.Maintenance;
import com.fireengineering.management.po.MaintenanceExample;
import com.fireengineering.management.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    MaintenanceMapper maintenanceMapper;

    public int getMaintenanceCount() {
        MaintenanceExample example = new MaintenanceExample();
        return maintenanceMapper.countByExample(example);

    }

    public List<Maintenance> getMaintenanceList(Integer offset, Integer limit) {
        return maintenanceMapper.selectByLimitAndOffset(offset, limit);
    }

    public int deleteMaintenanceById(Integer maintenanceId){
        return maintenanceMapper.deleteByPrimaryKey(maintenanceId);
    }

    public int addMaintenance(Maintenance maintenance) {
        return maintenanceMapper.insert(maintenance);
    }

    public int updateMaintenanceById(Maintenance maintenance) {
        return maintenanceMapper.updateByPrimaryKey(maintenance);
    }
}
